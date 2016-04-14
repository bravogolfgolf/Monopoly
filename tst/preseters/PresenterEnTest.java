package game.preseters;

import game.interactors.createplayer.CreatePlayerResponse;
import game.interactors.setupgame.SetupGameResponse;
import game.presenters.PresenterEn;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PresenterEnTest {

    private final PresenterEn presenter = new PresenterEn();
    private final SetupGameResponse setupGameResponse = new SetupGameResponse();
    private final CreatePlayerResponse createPlayerResponse = new CreatePlayerResponse();
    private String expected;

    @Before
    public void setUp() {
    }

    @Test
    public void testVersionCreatedMessage() {
        setupGameResponse.versions = new String[]{"USA"};
        presenter.versionCreatedMessage(setupGameResponse);
        expected = "USA version of game created.\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void testAvailableVersionsMessage() {
        setupGameResponse.versions = new String[]{"USA","FRA"};
        presenter.availableVersionsMessage(setupGameResponse);
        expected = "Available versions: FRA, USA\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void testSetupGamePromptMessage() {
        presenter.setupGamePromptMessage();
        expected = "Select version of game you would like to play.\n";
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
        createPlayerResponse.tokens = new String[]{"Cat"};
        presenter.playerCreatedMessage(createPlayerResponse);
        expected = "Player created with Cat token.\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void testPlayerPromptMessage() {
        presenter.playerPromptMessage();
        expected = "Please select token for player.\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void testAvailableTokensMessage() {
        createPlayerResponse.tokens = new String[]{"Wheelbarrow","Battleship","Scottish Terrier","Top Hat","Cat","Thimble","Boot","Automobile"};
        presenter.availableTokensMessage(createPlayerResponse);
        expected = "Available tokens: Automobile, Battleship, Boot, Cat, Scottish Terrier, Thimble, Top Hat, Wheelbarrow\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void testTokenInUseMessage() {
        createPlayerResponse.tokens = new String[]{"Cat"};
        presenter.tokenInUseMessage(createPlayerResponse);
        expected = "Cat token already in use.\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }
}