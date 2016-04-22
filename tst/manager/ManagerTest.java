package game.manager;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import game.presenters.PresenterEn;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static game.manager.UIStateImpl.*;
import static org.junit.Assert.assertEquals;

@RunWith(HierarchicalContextRunner.class)
public class ManagerTest {

    private final CommandFactoryFake factory = new CommandFactoryFake();
    private final PresenterEn presenter = new PresenterEn();
    private final UIManagerImpl manager = new UIManagerImpl(presenter, factory);
    private String expected;

    public class SetupGame {


        @Before
        public void setup() {
            manager.setUiState(SETUP_GAME);
        }

        @Test
        public void testUserPrompt() {
            manager.promptMessage();
            expected = "Select version of game you would like to play.\n";
            assertEquals(expected, presenter.getFormattedMessage());
            assertEquals("", factory.verifyMakeCommand);
            assertEquals(null, factory.verifyMakeState);
        }

        @Test
        public void testValidEntry() {
            manager.validUseCaseEntry();
            assertEquals("CreatePlayer", factory.verifyMakeCommand);
            assertEquals(CREATE_PLAYER_0, factory.verifyMakeState);
        }

        @Test
        public void testInvalidEntry() {
            manager.invalidEntry();
            assertEquals("SetupGame", factory.verifyMakeCommand);
            assertEquals(SETUP_GAME, factory.verifyMakeState);
        }
    }

    public class CreatePlayer {

        @Before
        public void setup() {
            manager.setUiState(CREATE_PLAYER_0);
        }

        @Test
        public void testUserPrompt() {
            manager.promptMessage();
            expected = "Please select tokens for players. (Players 2 - 8)\n";
            assertEquals(expected, presenter.getFormattedMessage());
            assertEquals("", factory.verifyMakeCommand);
            assertEquals(null, factory.verifyMakeState);
        }

        @Test
        public void testValidEntry() {
            manager.validUseCaseEntry();
            assertEquals("CreatePlayer", factory.verifyMakeCommand);
            assertEquals(CREATE_PLAYER_1, factory.verifyMakeState);
        }

        @Test
        public void testInvalidEntry() {
            manager.invalidEntry();
            assertEquals("CreatePlayer", factory.verifyMakeCommand);
            assertEquals(UIStateImpl.CREATE_PLAYER_0, factory.verifyMakeState);
        }
    }
}