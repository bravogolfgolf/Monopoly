package game.factories;

import game.interactors.setupgame.SetupGameFactory;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SetupGameFactoryTest {

    private final BoardMock board = new BoardMock();
    private final PlayerRepositoryImplMock player = new PlayerRepositoryImplMock();
    private final SetupGameFactory factory = new SetupGameFactoryImpl(board, player);

    @Test(expected = IllegalArgumentException.class)
    public void testMakeException() {
        factory.make("");
    }

    @Test
    public void testMake() {
        String[] versions = factory.getAvailableVersions();
        for (String version : versions) {
            factory.make(version);
            assertTrue(board.verifySetVersionCalled);
            assertTrue(player.verifySetTokensCalled);
        }

    }
}
