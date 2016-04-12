package game.interactors.createboard;

import game.controllers.Interactor;
import game.interactors.PresenterEnMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CreateBoardInteractorTest {

    private PresenterEnMock presenter;
    private BoardGatewayMock gateway;
    private Interactor interactor;
    private CreateBoardRequest request;

    @Before
    public void setUp() {
        presenter = new PresenterEnMock();
        request = new CreateBoardRequest();
    }

    @Test
    public void testBoardCreatedMessage() {
        gateway = new BoardGatewayValidRequestStub();
        interactor = new CreateBoardInteractor(presenter, gateway);

        request.version = "USA";
        interactor.handle(request);

        assertTrue(gateway.verifyCreateMethodCalled);
        assertTrue(presenter.verifyBoardCreateMessage);
    }

    @Test
    public void testBoardPromptMessageAndAvailableBoardsMessageWithInvalidInput() {
        gateway = new BoardGatewayInValidRequestStub();
        interactor = new CreateBoardInteractor(presenter, gateway);

        request.version = "TEST";
        interactor.handle(request);

        assertTrue(gateway.verifyIsAvailableCalled);
        assertTrue(presenter.verifyBoardPromptMessage);
        assertTrue(presenter.verifyAvailableBoardsMessage);
    }

    @Test
    public void testBoardPromptMessageAndAvailableBoardsMessageWithNullInput() {
        gateway = new BoardGatewayInValidRequestStub();
        interactor = new CreateBoardInteractor(presenter, gateway);

        request.version = null;
        interactor.handle(request);

        assertTrue(gateway.verifyAvailableBoardsCalled);
        assertTrue(presenter.verifyBoardPromptMessage);
        assertTrue(presenter.verifyAvailableBoardsMessage);
    }
}
