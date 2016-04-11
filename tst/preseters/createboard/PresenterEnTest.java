package game.preseters.createboard;

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
    public void setUp() throws Exception {
        createBoardResponse.message = "USA";
        createPlayerResponse.message = "Cat";
    }

    @Test
    public void validateViewRequest() {
        presenter.boardCreatedMessage(createBoardResponse);
        expected = addNewLine("USA version of board created.");
        assertEquals(expected, presenter.getViewRequest());

        presenter.boardPromptMessage();
        expected = addNewLine("Select version of board you would like to use.");
        assertEquals(expected, presenter.getViewRequest());

        presenter.exceededPlayerLimitMessage();
        expected = addNewLine("Exceeded eight player limit.");
        assertEquals(expected, presenter.getViewRequest());

        presenter.playerCreatedMessage(createPlayerResponse);
        expected = addNewLine("Player created with Cat token.");
        assertEquals(expected, presenter.getViewRequest());

        presenter.playerPromptMessage();
        expected = addNewLine("Please select token for player.");
        assertEquals(expected, presenter.getViewRequest());

        presenter.tokenInUseMessage(createPlayerResponse);
        expected = addNewLine("Cat token already in use.");
        assertEquals(expected, presenter.getViewRequest());
    }
}