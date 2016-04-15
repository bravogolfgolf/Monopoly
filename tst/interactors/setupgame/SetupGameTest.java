package game.interactors.setupgame;

import game.controllers.setupgame.SetupGameInteractor;
import game.interactors.PresenterEnMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SetupGameTest {

    private PresenterEnMock presenter;
    private SetupGameFactoryMock factory;
    private SetupGameInteractor interactor;
    private SetupGameRequest request;

    @Before
    public void setUp() {
        presenter = new PresenterEnMock();
        request = new SetupGameRequest();
    }

    @Test
    public void testBoardCreatedMessage() {
        factory = new SetupGameFactoryValidRequestStub();
        interactor = new SetupGame(presenter, factory);

        request.version = "USA";
        interactor.handle(request);

        assertTrue(factory.verifyCreateMethodCalled);
        assertTrue(presenter.verifyVersionCreatedMessage);
    }

    @Test
    public void testBoardPromptMessageAndAvailableBoardsMessageWithInvalidInput() {
        factory = new SetupGameFactoryInValidRequestStub();
        interactor = new SetupGame(presenter, factory);

        request.version = "TEST";
        interactor.handle(request);

        assertTrue(factory.verifyIsAvailableCalled);
        assertTrue(presenter.verifySetupGamePromptMessage);
        assertTrue(presenter.verifyAvailableVersionsMessage);
    }

    @Test
    public void testBoardPromptMessageAndAvailableBoardsMessageWithNullInput() {
        factory = new SetupGameFactoryInValidRequestStub();
        interactor = new SetupGame(presenter, factory);

        request.version = null;
        interactor.handle(request);

        assertTrue(factory.verifyAvailableBoardsCalled);
        assertTrue(presenter.verifySetupGamePromptMessage);
        assertTrue(presenter.verifyAvailableVersionsMessage);
    }
}
