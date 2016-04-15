package game.repositories;

import game.entitiies.Board;
import game.factories.SetupGameFactoryImpl;
import game.interactors.setupgame.SetupGameFactory;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
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
        player.create("Cat");
        assertTrue(repositoryHasOnePlayer());
        assertFalse(player.isAvailable("Cat"));
    }

    @Test
    public void testGetTokens() {
        String[] tokens = player.getAvailableTokens();
        assertTrue(tokens.length == 8);
    }

    private boolean repositoryHasOnePlayer() {
        return player.count() == 1;
    }
}