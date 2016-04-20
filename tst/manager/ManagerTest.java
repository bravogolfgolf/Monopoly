package game.manager;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static game.manager.StateImpl.PROMPT;
import static org.junit.Assert.assertEquals;

@RunWith(HierarchicalContextRunner.class)
public class ManagerTest {

    private final ControllerFactoryFake factory = new ControllerFactoryFake();

    public class SetupGame {

        private final SetupGameManager manager = new SetupGameManager(PROMPT, factory);

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

        private final CreatePlayerManager manager = new CreatePlayerManager(PROMPT, factory);

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