package game.interactors.createplayer;

import game.controllers.Interactor;
import game.interactors.PresenterEnMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CreatePlayerInteractorTest {

    private PlayerRepositoryFake gateway;
    private PresenterEnMock presenter;
    private Interactor interactor;
    private CreatePlayerRequest request;

    @Before
    public void setup() {
        gateway = new PlayerRepositoryFake();
        presenter = new PresenterEnMock();
        interactor = new CreatePlayerInteractor(presenter, gateway);
        request = new CreatePlayerRequest();
        request.token = "Cat";
    }

    @Test
    public void testPlayerCreated() {
        interactor.handle(request);

        assertTrue(gateway.verifyCreate);
        assertTrue(gateway.verifyCount);
        assertTrue(presenter.verifyPlayerCreatedMessage);
    }

    @Test
    public void testTokenInUse() {
        interactor.handle(request);
        interactor.handle(request);

        assertTrue(gateway.verifyCreate);
        assertTrue(gateway.verifyCount);
        assertTrue(presenter.verifyTokenInUseMessage);
    }

    @Test
    public void testExceededPlayerLimit() {
        sendRequestsForNinePlayers();

        assertTrue(gateway.verifyCreate);
        assertTrue(gateway.verifyCountCalledEightTimes);
        assertTrue(presenter.verifyExceededPlayerLimitMessage);
    }

    private void sendRequestsForNinePlayers() {
        for (int i = 1; i < 10; i++) {
            request.token = String.format("%d", i);
            interactor.handle(request);
        }
    }

    @Test
    public void testPlayerPrompt() {
        request.token = null;
        interactor.handle(request);

        assertFalse(gateway.verifyCreate);
        assertFalse(gateway.verifyCount);
        assertTrue(presenter.verifyPlayerPromptMessage);
    }

}

