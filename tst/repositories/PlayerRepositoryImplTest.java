package game.repositories;

import game.entitiies.Board;
import game.factories.SetupGameFactoryImpl;
import game.interactors.setupgame.SetupGameFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlayerRepositoryImplTest {
    private final Board board = new BoardDummy();
    private final PlayerRepositoryImpl player = new PlayerRepositoryImpl();
    private final SetupGameFactory factory = new SetupGameFactoryImpl(board, player);

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
    public void testGetTokens() {
        String[] tokens = player.getAvailableTokens();
        assertTrue(tokens.length == 8);
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