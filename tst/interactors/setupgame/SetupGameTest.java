package game.interactors.setupgame;

import game.controllers.setupgame.SetupGameInteractor;
import game.interactors.PresenterEnMock;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SetupGameTest {

    private final PresenterEnMock presenter = new PresenterEnMock();
    private final SetupGameFactoryFake factory = new SetupGameFactoryFake();
    private final SetupGameInteractor interactor = new SetupGame(presenter, factory);
    private final SetupGameRequest request = new SetupGameRequest();

    @Test
    public void testValidRequest() {
        request.version = "Valid";
        interactor.handle(request);

        assertTrue(factory.verifyCreateMethodCalled);
        assertTrue(presenter.verifyVersionCreatedMessage);
    }

    @Test
    public void testAvailableVersionsMessage() {
        interactor.availableVersionsMessage();

        assertTrue(presenter.verifyAvailableVersionsMessage);
        assertTrue(factory.verifyGetAvailableVersionsCalled);
    }
}
