package game.presenters;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import game.doubles.ConsoleMock;
import game.doubles.ParserMock;
import game.interactors.gotojail.GoToJailResponse;
import game.interactors.landon.LandOnResponse;
import game.interactors.movetoken.MoveTokenResponse;
import game.interactors.partneroptions.PartnerOptionsResponse;
import game.interactors.propertyoptions.PropertyOptionsResponse;
import game.interactors.rolldice.RollDiceResponse;
import game.interactors.selectfirst.SelectFirstResponse;
import game.interactors.tokenoptions.TokenOptionsResponse;
import game.interactors.versionoptions.VersionOptionsResponse;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(HierarchicalContextRunner.class)
public class PresenterEnTest {

    private final ParserMock parser = new ParserMock();
    private final ConsoleMock console = new ConsoleMock(parser);
    private final Presenter presenter = new PresenterEn(console, parser);
    private String expected;

    private void verifyMessage() throws IOException {
        presenter.writeMessage();
        assertEquals(expected, console.verifyWriteMessage);
    }

    private void verifyMenuMap(Map<Integer, String> expected) throws IOException {
        presenter.writeMessage();
        assertEquals(expected, parser.verifySetMapValue);
    }

    public class PresenterTest {

        @Test
        public void testGetMenuMap() throws IOException {
            Map<Integer, String> expected = new Hashtable<Integer, String>() {{
                put(1, "Cat");
            }};
            presenter.createMenuMap(new String[]{"Cat"});
            verifyMenuMap(expected);
        }
    }

    public class SelectVersionTest {

        @Test
        public void testSelectVersionPromptMessage() throws IOException {
            presenter.selectVersionPromptMessage();
            expected = "\nSelect version of game you would like to play.\n";
            verifyMessage();
        }

        public class VersionOptionsResponseTest {

            private final VersionOptionsResponse response = new VersionOptionsResponse();

            @Test
            public void testAvailableVersionsMessage() throws IOException {
                response.versions = new String[]{"FRA", "USA"};
                presenter.availableVersionsMessage(response);
                expected = "Available versions: (1)FRA, (2)USA\n";
                verifyMessage();
            }

            @Test
            public void testVersionCreatedMessage() throws IOException {
                response.version = "USA";
                presenter.versionCreatedMessage(response);
                expected = "\nUSA version of game created.\n";
                verifyMessage();
            }
        }
    }

    public class CreatePlayerTest {

        @Test
        public void testCreatePlayerPromptMessageFewerThanTwo() throws IOException {
            presenter.createPlayerPromptMessageFewerThanMinimumMessage();
            expected = "\nPlease select token for player. (Players 2 - 8)\n";
            verifyMessage();
        }

        @Test
        public void testCreatePlayerPromptMessageTwoOrMore() throws IOException {
            presenter.createPlayerPromptMessageMinimumToMaximumMessage();
            expected = "\nPlease select token for player or (0)Play to begin. (Players 2 - 8)\n";
            verifyMessage();
        }

        public class TokenOptionsResponseTest {

            private final TokenOptionsResponse response = new TokenOptionsResponse();

            @Test
            public void testAvailableTokensMessage() throws IOException {
                response.tokens = new String[]{"Automobile", "Battleship", "Boot", "Cat", "Scottish Terrier", "Thimble", "Top Hat", "Wheelbarrow"};
                presenter.availableTokensMessage(response);
                expected = "Available tokens: (1)Automobile, (2)Battleship, (3)Boot, (4)Cat, (5)Scottish Terrier, (6)Thimble, (7)Top Hat, (8)Wheelbarrow\n";
                verifyMessage();
            }

            @Test
            public void testPlayerCreatedMessage() throws IOException {
                response.token = "Cat";
                presenter.playerCreatedMessage(response);
                expected = "\nPlayer created with Cat token.\n";
                verifyMessage();
            }
        }
    }

    public class SelectFirstTest {

        private final SelectFirstResponse response = new SelectFirstResponse();

        @Test
        public void testPlayerSelectedToGoFirstMessage() throws IOException {
            response.token = "Cat";
            presenter.playerSelectedToGoFirstMessage(response);
            expected = "\nCat selected to go first.\n";
            verifyMessage();
        }
    }

    public class StartTurnTest {

        @Test
        public void testStartTurnMessage() throws IOException {
            presenter.startTurnMessage();
            expected = "\nAvailable options: (0)Roll (1)Manage Properties (2)Trade.\n";
            verifyMessage();
        }
    }

    public class PropertyOptionsTest {

        @Test
        public void testSelectPropertyPromptMessage() throws IOException {
            presenter.selectPropertyPromptMessage();
            expected = "\nSelect property to manage or (0)Done to return to previous menu.\n";
            verifyMessage();
        }

        public class PropertyOptionsResponseTest {

            private final PropertyOptionsResponse response = new PropertyOptionsResponse();

            @Test
            public void testPropertyOptionsMessage() throws IOException {
                presenter.propertyOptionsMessage(response);
                expected = "\nNo properties to manage.\n";
                verifyMessage();
            }
        }
    }

    public class SelectTradingPartnerTest {

        @Test
        public void testTrade() throws IOException {
            presenter.selectTradingPartnerPromptMessage();
            expected = "\nSelect player to trade with or (0)Done to return to previous menu.\n";
            verifyMessage();
        }

        public class PartnerOptionsResponseTest {

            private final PartnerOptionsResponse response = new PartnerOptionsResponse();

            @Test
            public void testPartnerOptionsMessage() throws IOException {
                response.players = new String[]{"Cat", "Boot"};
                presenter.partnerOptionsMessage(response);
                expected = "Available trading partners: (1)Cat, (2)Boot\n";
                verifyMessage();
            }
        }
    }

    public class RollDiceTest {

        private final RollDiceResponse response = new RollDiceResponse();

        @Test
        public void testRollMessageWithoutDoubles() throws IOException {
            response.rolled = 2;
            response.isDoubles = false;
            presenter.rollMessage(response);
            expected = "\nYou rolled 2.\n";
            verifyMessage();
        }

        @Test
        public void testRollMessageWithDoubles() throws IOException {
            response.rolled = 2;
            response.isDoubles = true;
            presenter.rollMessage(response);
            expected = "\nDoubles! You rolled 2.\n";
            verifyMessage();
        }
    }

    public class MoveTokenTest {

        private final MoveTokenResponse response = new MoveTokenResponse();

        @Test
        public void testPassGoMessage() throws IOException {
            response.GO = "GO";
            presenter.passGoMessage(response);
            expected = "\nPassed GO!\n";
            verifyMessage();
        }
    }

    public class paySalaryTest {

        @Test
        public void testPaySalaryMessage() throws IOException {
            presenter.paySalaryMessage();
            expected = "\nCollect 200.\n";
            verifyMessage();
        }
    }

    public class landOnTest {

        private final LandOnResponse response = new LandOnResponse();

        @Test
        public void testLandOnMessage() throws IOException {
            response.space = "GO";
            presenter.landOnMessage(response);
            expected = "\nLanded on GO.\n";
            verifyMessage();
        }
    }

    public class goToJailTest {

        private final GoToJailResponse response = new GoToJailResponse();

        @Test
        public void testGotToJailMessage() throws IOException {
            response.GO = "GO";
            presenter.goToJailMessage(response);
            expected = "\nDo not pass GO. Do not collect 200.\n";
            verifyMessage();
        }
    }
}