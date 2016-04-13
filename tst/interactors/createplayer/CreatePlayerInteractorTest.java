package game.interactors.createplayer;

import game.controllers.createPlayer.CreatePlayerControllerInteractor;
import game.interactors.PresenterEnMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CreatePlayerInteractorTest {

    private CreatePlayerRepositoryMock repository;
    private PresenterEnMock presenter;
    private CreatePlayerControllerInteractor interactor;
    private CreatePlayerRequest request;

    @Before
    public void setup() {
        repository = new CreatePlayerRepositoryMock();
        presenter = new PresenterEnMock();
        interactor = new CreatePlayerInteractor(presenter, repository);
        request = new CreatePlayerRequest();
        request.token = "Cat";
    }

    @Test
    public void testPlayerCreated() {
        interactor.handle(request);

        assertTrue(repository.verifyCreate);
        assertTrue(repository.verifyCount);
        assertTrue(presenter.verifyPlayerCreatedMessage);
    }

    @Test
    public void testTokenInUse() {
        interactor.handle(request);
        interactor.handle(request);

        assertTrue(repository.verifyCreate);
        assertTrue(repository.verifyCount);
        assertTrue(presenter.verifyTokenInUseMessage);
    }

    @Test
    public void testExceededPlayerLimit() {
        sendRequestsForNinePlayers();

        assertTrue(repository.verifyCreate);
        assertTrue(repository.verifyCountCalledEightTimes);
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

        assertFalse(repository.verifyCreate);
        assertFalse(repository.verifyCount);
        assertTrue(presenter.verifyPlayerPromptMessage);
    }

}

