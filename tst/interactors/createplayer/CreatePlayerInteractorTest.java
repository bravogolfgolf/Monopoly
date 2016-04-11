package game.interactors.createplayer;

import game.controllers.Interactor;
import org.junit.Before;
import org.junit.Test;

import static game.utilities.StringFormatter.addNewLine;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreatePlayerInteractorTest {

    private PlayerRepositoryFake gateway;
    private CreatePlayerPresenterMock presenter;
    private Interactor interactor;
    private CreatePlayerRequest request;
    private String expected;

    @Before
    public void setup() {
        gateway = new PlayerRepositoryFake();
        presenter = new CreatePlayerPresenterMock();
        interactor = new CreatePlayerInteractor(presenter, gateway);
        request = new CreatePlayerRequest();
        request.token = "Cat";
        expected = addNewLine("Player created with Cat token.");
    }

    @Test
    public void validRequestToCreatePlayerWithUniqueToken() {
        expected = addNewLine("Player created with Cat token.");

        interactor.handle(request);

        assertTrue(gateway.VerifyCreateMethodCalled);
        assertTrue(gateway.VerifyCountMethodCalled);
        assertTrue(presenter.VerifyPresentMethodCalled);
        assertEquals(expected, presenter.getViewRequest());
    }

    @Test
    public void validRequestToCreatePlayerWithNonUniqueTokenFails() {
        expected = addNewLine("Token already in use.");

        interactor.handle(request);
        interactor.handle(request);

        assertEquals(expected, presenter.getViewRequest());
    }

    @Test
    public void creatingMoreThanEightPlayers_ReturnsNumberOfPlayersExceededMessage() {
        expected = addNewLine("Exceeded eight player limit.");

        sendRequestsForNinePlayers();

        assertEquals(expected, presenter.getViewRequest());
    }

    private void sendRequestsForNinePlayers() {
        for (int i = 1; i < 10; i++) {
            request.token = String.format("%d", i);
            interactor.handle(request);
        }
    }

    @Test
    public void nullRequestReturnsPrompt() {
        expected = addNewLine("Please select token for player.");

        request.token = null;
        interactor.handle(request);

        assertEquals(expected, presenter.getViewRequest());
    }
}

