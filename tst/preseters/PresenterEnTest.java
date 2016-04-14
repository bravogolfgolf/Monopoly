package game.preseters;

import game.interactors.createplayer.CreatePlayerResponse;
import game.interactors.setupgame.SetupGameResponse;
import game.presenters.PresenterEn;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PresenterEnTest {

    private final PresenterEn presenter = new PresenterEn();
    private final SetupGameResponse setupGameResponse = new SetupGameResponse();
    private final CreatePlayerResponse createPlayerResponse = new CreatePlayerResponse();
    private String expected;

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
        expected = "Available versions: (1)FRA, (2)USA\n";
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
        expected = "Available tokens: (1)Automobile, (2)Battleship, (3)Boot, (4)Cat, (5)Scottish Terrier, (6)Thimble, (7)Top Hat, (8)Wheelbarrow\n";
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