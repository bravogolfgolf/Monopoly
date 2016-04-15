package game.interactors.createplayer;

import game.controllers.createPlayer.CreatePlayerInteractor;
import game.interactors.PresenterEnMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CreatePlayerTest {

    private CreatePlayerRepositoryMock player;
    private PresenterEnMock presenter;
    private CreatePlayerInteractor interactor;
    private CreatePlayerRequest request;

    @Before
    public void setup() {
        player = new CreatePlayerRepositoryMock();
        presenter = new PresenterEnMock();
        interactor = new CreatePlayer(presenter, player);
        request = new CreatePlayerRequest();
        request.token = "Cat";
    }

    @Test
    public void testExceededPlayerLimit() {
        sendNineRequests();

        assertTrue(player.verifyPlayerLimitExceededCalled);
        assertTrue(player.verifyCreateCalled);
        assertTrue(player.verifyCreateCalledEightTimes);
        assertTrue(presenter.verifyExceededPlayerLimitMessage);
    }

    private void sendNineRequests() {
        for (int i = 1; i < 10; i++) {
            request.token = String.format("%d", i);
            interactor.handle(request);
        }
    }

    @Test
    public void testPlayerCreated() {
        interactor.handle(request);

        assertTrue(player.verifyPlayerLimitExceededCalled);
        assertTrue(player.verifyCreateCalled);
        assertTrue(presenter.verifyPlayerCreatedMessage);
    }

    @Test
    public void testPlayerPrompt() {
        request.token = null;
        interactor.handle(request);

        assertTrue(presenter.verifyCreatePlayerPromptMessage);
        assertTrue(presenter.verifyAvailableTokensMessage);
    }

    @Test
    public void testTokenInUse() {
        interactor.handle(request);
        interactor.handle(request);

        assertTrue(player.verifyPlayerLimitExceededCalled);
        assertTrue(player.verifyCreateCalled);
        assertTrue(presenter.verifyTokenInUseMessage);
        assertTrue(presenter.verifyPlayerCreatedMessage);
        assertTrue(player.verifyGetAvailableTokensCalled);
        assertTrue(presenter.verifyAvailableTokensMessage);
    }

}

