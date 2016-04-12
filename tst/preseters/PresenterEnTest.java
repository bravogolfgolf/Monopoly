package game.preseters;

import game.interactors.createboard.CreateBoardResponse;
import game.interactors.createplayer.CreatePlayerResponse;
import game.presenters.PresenterEn;
import org.junit.Before;
import org.junit.Test;

import static game.utilities.StringFormatter.addNewLine;
import static org.junit.Assert.assertEquals;

public class PresenterEnTest {

    private final PresenterEn presenter = new PresenterEn();
    private final CreateBoardResponse createBoardResponse = new CreateBoardResponse();
    private final CreatePlayerResponse createPlayerResponse = new CreatePlayerResponse();
    private String expected;

    @Before
    public void setUp() {
        createBoardResponse.versions = new String[]{"USA"};
        createPlayerResponse.tokens = new String[]{"Cat"};
    }

    @Test
    public void boardCreatedMessage() {
        presenter.boardCreatedMessage(createBoardResponse);
        expected = addNewLine("USA versions of board created.");
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void availableBoardsMessage() {
        presenter.availableBoardsMessage(createBoardResponse);
        expected = addNewLine("Available boards: USA");
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void boardPromptMessage() {
        presenter.boardPromptMessage();
        expected = addNewLine("Select versions of board you would like to use.");
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void exceededPlayerLimitMessage() {
        presenter.exceededPlayerLimitMessage();
        expected = addNewLine("Exceeded eight player limit.");
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void playerCreatedMessage() {
        presenter.playerCreatedMessage(createPlayerResponse);
        expected = addNewLine("Player created with Cat tokens.");
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void playerPromptMessage() {
        presenter.playerPromptMessage();
        expected = addNewLine("Please select tokens for player.");
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void tokenInUseMessage() {
        presenter.tokenInUseMessage(createPlayerResponse);
        expected = addNewLine("Cat tokens already in use.");
        assertEquals(expected, presenter.getFormattedMessage());
    }
}