package game.manager;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import game.presenters.PresenterEn;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static game.manager.UIStateImpl.CREATE_PLAYER_0;
import static game.manager.UIStateImpl.SETUP_GAME;
import static org.junit.Assert.assertEquals;

@RunWith(HierarchicalContextRunner.class)
public class ManagerTest {

    private final CommandFactoryFake factory = new CommandFactoryFake();
    private final PresenterEn presenter = new PresenterEn();
    private String expected;

    public class SetupGame {

        private final UIManagerSetupGame manager = new UIManagerSetupGame(presenter, factory);

        @Before
        public void setup() {
            manager.setUiState(SETUP_GAME);
        }

        @Test
        public void testUserPrompt() {
            manager.promptMessage();
            expected = "Select version of game you would like to play.\n";
            assertEquals(expected, presenter.getFormattedMessage());
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

        private final UIManagerCreatePlayer manager = new UIManagerCreatePlayer(presenter, factory);


        @Before
        public void setup() {
            manager.setUiState(CREATE_PLAYER_0);
        }

        @Test
        public void testUserPrompt() {
            manager.promptMessage();
            expected = "Please select tokens for players. (Player 2 - 8)\n";
            assertEquals(expected, presenter.getFormattedMessage());
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