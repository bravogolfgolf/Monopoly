package game.manager;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import game.Monopoly;
import game.presenters.PresenterEn;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static game.manager.UIStateImpl.CREATE_PLAYER_0;
import static game.manager.UIStateImpl.SETUP_GAME;
import static org.junit.Assert.assertEquals;

@RunWith(HierarchicalContextRunner.class)
public class ManagerTest {

    private final PresenterEn presenter = new PresenterEn();
    private final UIManagerImpl manager = new UIManagerImpl(presenter);
    private String expected;

    public class SetupGame {

        @Before
        public void setup() {
            manager.setUiState(SETUP_GAME);
            Monopoly.list.clear();
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
            assertEquals(1, Monopoly.list.size());
        }

        @Test
        public void testInvalidEntry() {
            manager.invalidEntry();
            assertEquals(1, Monopoly.list.size());
        }
    }

    public class CreatePlayer {

        @Before
        public void setup() {
            manager.setUiState(CREATE_PLAYER_0);
            Monopoly.list.clear();
        }

        @Test
        public void testUserPrompt() {
            manager.promptMessage();
            expected = "Please select tokens for players. (Players 2 - 8)\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }

        @Test
        public void testValidEntry() {
            manager.validUseCaseEntry();
            assertEquals(1, Monopoly.list.size());
        }

        @Test
        public void testInvalidEntry() {
            manager.invalidEntry();
            assertEquals(1, Monopoly.list.size());
        }
    }
}