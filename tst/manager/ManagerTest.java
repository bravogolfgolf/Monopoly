package game.manager;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import game.Monopoly;
import game.presenters.PresenterEn;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static game.manager.UIStateImpl.*;
import static org.junit.Assert.assertEquals;

@RunWith(HierarchicalContextRunner.class)
public class ManagerTest {

    private final PresenterEn presenter = new PresenterEn();
    private final UIManagerImpl manager = new UIManagerImpl(presenter);
    private String expected;

    public class SETUP_GAME {

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
        public void testZeroEntered(){
            manager.zeroEntered();
            assertEquals(1, Monopoly.list.size());
        }

        @Test
        public void testValidUseCaseEntry() {
            manager.validUseCaseEntry();
            assertEquals(1, Monopoly.list.size());
        }

        @Test
        public void testInvalidEntry() {
            manager.invalidEntry();
            assertEquals(1, Monopoly.list.size());
        }
    }

    public class CREATE_PLAYER_0 {

        @Before
        public void setup() {
            manager.setUiState(CREATE_PLAYER_0);
            Monopoly.list.clear();
        }

        @Test
        public void testUserPrompt() {
            manager.promptMessage();
            expected = "Please select token for player. (Players 2 - 8)\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }

        @Test
        public void testZeroEntered(){
            manager.zeroEntered();
            assertEquals(1, Monopoly.list.size());
        }

        @Test
        public void testValidUseCaseEntry() {
            manager.validUseCaseEntry();
            assertEquals(1, Monopoly.list.size());
        }

        @Test
        public void testInvalidEntry() {
            manager.invalidEntry();
            assertEquals(1, Monopoly.list.size());
        }
    }

    public class CREATE_PLAYER_2 {

        @Before
        public void setup() {
            manager.setUiState(CREATE_PLAYER_2);
            Monopoly.list.clear();
        }

        @Test
        public void testUserPrompt() {
            manager.promptMessage();
            expected = "Please select token for player or 0 to begin play. (Players 2 - 8)\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }

        @Test
        public void testZeroEntered(){
            manager.zeroEntered();
//            Not defined yet
//            assertEquals(1, Monopoly.list.size());
        }

        @Test
        public void testValidUseCaseEntry() {
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