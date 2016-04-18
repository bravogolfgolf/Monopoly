package game.manager;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static game.manager.StateImpl.PROMPT;
import static org.junit.Assert.assertTrue;

@RunWith(HierarchicalContextRunner.class)
public class ManagerTest {

    private final ControllerFactoryFake factory = new ControllerFactoryFake();

    public class SetupGame {

        private final SetupGameManagerFake manager = new SetupGameManagerFake(PROMPT, factory);

        @Test
        public void testValidNumber () {
            manager.validNumberEntered();
            assertTrue(manager.addNextCommandToList);
        }

        @Test
        public void testInvalidText () {
            manager.invalidTextEntered();
            assertTrue(manager.addCommandBackToListCalled);
            assertTrue(factory.verifyMakeCalled);
        }

        @Test
        public void testInvalidNumber () {
            manager.invalidNumberEntered();
            assertTrue(manager.addCommandBackToListCalled);
            assertTrue(factory.verifyMakeCalled);
        }
    }

    public class CreatePlayer {

        private final CreatePlayerManagerFake manager = new CreatePlayerManagerFake(PROMPT, factory);

        @Test
        public void testValidNumber () {
            manager.validNumberEntered();
            assertTrue(manager.addNextCommandToList);
        }

        @Test
        public void testInvalidText () {
            manager.invalidTextEntered();
            assertTrue(manager.addCommandBackToListCalled);
            assertTrue(factory.verifyMakeCalled);
        }

        @Test
        public void testInvalidNumber () {
            manager.invalidNumberEntered();
            assertTrue(manager.addCommandBackToListCalled);
            assertTrue(factory.verifyMakeCalled);
        }
    }
}