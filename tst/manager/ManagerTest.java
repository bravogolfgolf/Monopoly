package game.manager;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static game.manager.StateImpl.CREATE_PLAYER_0;
import static game.manager.StateImpl.SETUP_GAME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(HierarchicalContextRunner.class)
public class ManagerTest {

    private final ControllerFactoryFake factory = new ControllerFactoryFake();
    private final PresenterEnMock presenter = new PresenterEnMock();

    public class SetupGame {

        private final SetupGameManagerUI manager = new SetupGameManagerUI(presenter, factory);

        @Before
        public void setup() {
            manager.setStateUI(SETUP_GAME);
        }

        @Test
        public void testUserPrompt() {
            manager.promptMessage();
            assertTrue(presenter.setupGamePromptMessage);
        }


        @Test
        public void testValidEntry() {
            manager.validUseCaseEntry();
            assertEquals("CreatePlayer", factory.verifyMakeString);
        }

        @Test
        public void testInvalidEntry() {
            manager.invalidEntry();
            assertEquals("SetupGame", factory.verifyMakeString);
        }
    }

    public class CreatePlayer {

        private final CreatePlayerManagerUI manager = new CreatePlayerManagerUI(presenter, factory);


        @Before
        public void setup() {
            manager.setStateUI(CREATE_PLAYER_0);
        }

        @Test
        public void testUserPrompt() {
            manager.promptMessage();
            assertTrue(presenter.setupGamePromptMessage);
        }

        @Test
        public void testValidEntry() {
            manager.validUseCaseEntry();
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