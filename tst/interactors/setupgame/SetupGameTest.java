package game.interactors.setupgame;

import game.controllers.Interactor;
import game.interactors.InteractorRequest;
import game.interactors.PresenterEnMock;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SetupGameTest {

    private final PresenterEnMock presenter = new PresenterEnMock();
    private final SetupGameFactoryFake factory = new SetupGameFactoryFake();
    private final Interactor interactor = new SetupGame(presenter, factory);
    private final InteractorRequest request = new InteractorRequest();

    @Test
    public void testValidRequest() {
        request.string = "Valid";
        interactor.handle(request);

        assertTrue(factory.verifyCreateMethodCalled);
        assertTrue(presenter.verifyVersionCreatedMessage);
    }

    @Test
    public void testAvailableVersionsMessage() {
        interactor.userInterfaceOptions();

        assertTrue(presenter.verifyAvailableVersionsMessage);
        assertTrue(factory.verifyGetAvailableVersionsCalled);
    }
}
