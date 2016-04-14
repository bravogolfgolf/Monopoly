package game.factories;

import game.interactors.setupgame.SetupGameFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SetupGameFactoryTest {

    private SetupGameFactory factory;
    private BoardMock board;
    private PlayerRepositoryImplMock player;

    @Before
    public void setUp() {
        board = new BoardMock();
        player = new PlayerRepositoryImplMock();
        factory = new SetupGameFactoryImpl(board, player);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMakeException() {
        factory.make("");
    }

    @Test
    public void testMakeCallsBoard() {
        factory.make("USA");
        assertTrue(board.verifySetVersionCalled);
        assertTrue(player.verifySetTokensCalled);
    }
}
