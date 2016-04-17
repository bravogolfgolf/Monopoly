package game.presenters;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import game.interactors.createplayer.CreatePlayerResponse;
import game.interactors.setupgame.SetupGameResponse;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(HierarchicalContextRunner.class)
public class PresenterEnTest {

    private final PresenterEn presenter = new PresenterEn();
    private String expected;

    public class setupGame {

        private final SetupGameResponse response = new SetupGameResponse();

        @Test
        public void testVersionCreatedMessage() {
            response.versions = new String[]{"USA"};
            presenter.versionCreatedMessage(response);
            expected = "USA version of game created.\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }

        @Test
        public void testAvailableVersionsMessage() {
            response.versions = new String[]{"FRA", "USA"};
            presenter.availableVersionsMessage(response);
            expected = "Available versions: (1)FRA, (2)USA\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }

        @Test
        public void testSetupGamePromptMessage() {
            presenter.setupGamePromptMessage();
            expected = "Select version of game you would like to play.\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }
    }

    public class createPlayer {

        private final CreatePlayerResponse response = new CreatePlayerResponse();

        @Test
        public void testCreatePlayerPrompt() {
            response.tokens = new String[]{"Cat"};
            presenter.createPlayerPromptMessage();
            expected = "Please select token for player.\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }

        @Test
        public void testExceededPlayerLimitMessage() {
            presenter.exceededPlayerLimitMessage();
            expected = "Exceeded eight player limit.\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }

        @Test
        public void testPlayerCreatedMessage() {
            response.tokens = new String[]{"Cat"};
            presenter.playerCreatedMessage(response);
            expected = "Player created with Cat token.\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }

        @Test
        public void testPlayerPromptMessage() {
            presenter.createPlayerPromptMessage();
            expected = "Please select token for player.\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }

        @Test
        public void testAvailableTokensMessage() {
            response.tokens = new String[]{"Automobile", "Battleship", "Boot", "Cat", "Scottish Terrier", "Thimble", "Top Hat", "Wheelbarrow"};
            presenter.availableTokensMessage(response);
            expected = "Available tokens: (1)Automobile, (2)Battleship, (3)Boot, (4)Cat, (5)Scottish Terrier, (6)Thimble, (7)Top Hat, (8)Wheelbarrow\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }
    }
}