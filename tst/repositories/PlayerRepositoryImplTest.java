package game.repositories;

import game.entitiies.Board;
import game.entitiies.Token;
import game.factories.SetupGameFactoryImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class PlayerRepositoryImplTest {
    private final Board board = new BoardDummy();
    private final PlayerRepositoryImpl player = new PlayerRepositoryImpl();
    private final SetupGameFactoryImpl factory = new SetupGameFactoryImpl(board, player);

    @Before
    public void setUp() {
        factory.make("USA");
    }

    @Test
    public void testCreatePlayer() {
        assertTrue(repositoryIsEmpty());
        player.create("Cat");
        assertTrue(repositoryHasOnePlayer());
        player.create("Cat");
        assertTrue(duplicatePlayerNotCreated());
    }

    @Test
    public void testSetTokens() {
        Token token = new Token("Cat");
        List<Token> tokens = new ArrayList<>();
        tokens.add(token);
        player.setTokens(tokens);
    }

    private boolean repositoryIsEmpty() {
        return player.count() == 0;
    }

    private boolean repositoryHasOnePlayer() {
        return player.count() == 1;
    }

    private boolean duplicatePlayerNotCreated() {
        return player.count() == 1;
    }
}