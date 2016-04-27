package game.presenters;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import game.interactors.createplayer.CreatePlayerResponse;
import game.interactors.selectfirst.SelectFirstResponse;
import game.interactors.selectversion.SelectVersionResponse;
import game.interactors.tokenoptions.TokenOptionsResponse;
import game.interactors.versionoptions.VersionOptionsResponse;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Hashtable;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(HierarchicalContextRunner.class)
public class PresenterEnTest {

    private final Presenter presenter = new PresenterEn();
    private String expected;

    public class PresenterTest {

        @Test
        public void testGetMenuMap() {
            Map<Integer, String> expected = new Hashtable<Integer, String>() {{
                put(1, "Cat");
            }};
            presenter.clearAndCreateMenuMap(new String[]{"Cat"});
            assertEquals(expected, presenter.returnAndClearMenuMap());
        }
    }

    public class SelectVersionTest {

        @Test
        public void testSelectVersionPromptMessage() {
            presenter.selectVersionPromptMessage();
            expected = "\nSelect version of game you would like to play.\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }

        public class SelectVersionResponseTest {

            private final SelectVersionResponse response = new SelectVersionResponse();

            @Test
            public void testVersionCreatedMessage() {
                response.version = "USA";
                presenter.versionCreatedMessage(response);
                expected = "\nUSA version of game created.\n";
                assertEquals(expected, presenter.getFormattedMessage());
            }
        }
    }

    public class CreatePlayerTest {

        @Test
        public void testCreatePlayerPromptMessageFewerThanTwo() {
            presenter.createPlayerPromptMessageFewerThanMinimumMessage();
            expected = "\nPlease select token for player. (Players 2 - 8)\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }

        @Test
        public void testCreatePlayerPromptMessageTwoOrMore() {
            presenter.createPlayerPromptMessageMinimumToMaximumMessage();
            expected = "\nPlease select token for player or (0)Play to begin. (Players 2 - 8)\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }

        public class CreatePlayerResponseTest {

            private final CreatePlayerResponse response = new CreatePlayerResponse();

            @Test
            public void testPlayerCreatedMessage() {
                response.token = "Cat";
                presenter.playerCreatedMessage(response);
                expected = "\nPlayer created with Cat token.\n";
                assertEquals(expected, presenter.getFormattedMessage());
            }
        }
    }

    public class VersionOptionsResponseTest {

        private final VersionOptionsResponse response = new VersionOptionsResponse();

        @Test
        public void testAvailableVersionsMessage() {
            response.versions = new String[]{"FRA", "USA"};
            presenter.availableVersionsMessage(response);
            expected = "Available versions: (1)FRA, (2)USA\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }
    }

    public class TokenOptionsResponseTest {

        private final TokenOptionsResponse response = new TokenOptionsResponse();

        @Test
        public void testAvailableTokensMessage() {
            response.tokens = new String[]{"Automobile", "Battleship", "Boot", "Cat", "Scottish Terrier", "Thimble", "Top Hat", "Wheelbarrow"};
            presenter.availableTokensMessage(response);
            expected = "Available tokens: (1)Automobile, (2)Battleship, (3)Boot, (4)Cat, (5)Scottish Terrier, (6)Thimble, (7)Top Hat, (8)Wheelbarrow\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }
    }

    public class SelectFirstResponseTest {

        private final SelectFirstResponse response = new SelectFirstResponse();

        @Test
        public void testPlayerSelectedToGoFirstMessage() {
            response.token = "Cat";
            presenter.playerSelectedToGoFirstMessage(response);
            expected = "\nCat selected to go first.\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }
    }

    public class StartTurnPresenterTest {

        @Test
        public void testStartTurnMessage() {
            presenter.startTurn();
            expected = "\nAvailable options: (0)Roll (1)Manage Properties (2)Trade.\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }
    }
}