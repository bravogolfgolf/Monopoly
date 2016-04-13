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
        createPlayerResponse.tokens = new String[]{"Cat"};
    }

    @Test
    public void boardCreatedMessage() {
        setupGameResponse.versions = new String[]{"USA"};
        presenter.boardCreatedMessage(setupGameResponse);
        expected = "USA version of game created.\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void availableBoardsMessage() {
        setupGameResponse.versions = new String[]{"USA","FRA"};
        presenter.availableBoardsMessage(setupGameResponse);
        expected = "Available versions: FRA, USA\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void boardPromptMessage() {
        presenter.boardPromptMessage();
        expected = "Select version of game you would like to play.\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void exceededPlayerLimitMessage() {
        presenter.exceededPlayerLimitMessage();
        expected = "Exceeded eight player limit.\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void playerCreatedMessage() {
        presenter.playerCreatedMessage(createPlayerResponse);
        expected = "Player created with Cat token.\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void playerPromptMessage() {
        presenter.playerPromptMessage();
        expected = "Please select token for player.\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void tokenInUseMessage() {
        presenter.tokenInUseMessage(createPlayerResponse);
        expected = "Cat token already in use.\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }
}