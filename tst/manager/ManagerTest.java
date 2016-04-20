package game.manager;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static game.manager.StateImpl.CREATE_PLAYER;
import static game.manager.StateImpl.SETUP_GAME;
import static org.junit.Assert.assertEquals;

@RunWith(HierarchicalContextRunner.class)
public class ManagerTest {

    private final ControllerFactoryFake factory = new ControllerFactoryFake();

    public class SetupGame {

        private final SetupGameManager manager = new SetupGameManager(SETUP_GAME, factory);

        @Test
        public void testValidEntry() {
            manager.validEntry();
            assertEquals("CreatePlayer", factory.verifyMakeString);
        }

        @Test
        public void testInvalidEntry() {
            manager.invalidEntry();
            assertEquals("SetupGame", factory.verifyMakeString);
        }
    }

    public class CreatePlayer {

        private final CreatePlayerManager manager = new CreatePlayerManager(CREATE_PLAYER, factory);

        @Test
        public void testValidEntry() {
            manager.validEntry();
//            Next Step not available yet
//            assertEquals("", factory.verifyMakeString);
        }

        @Test
        public void testInvalidEntry() {
            manager.invalidEntry();
            assertEquals("CreatePlayer", factory.verifyMakeString);
        }
    }
}