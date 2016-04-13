package game.interactors.createboard;

import game.controllers.createBoard.CreateBoardControllerInteractor;
import game.interactors.PresenterEnMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CreateBoardInteractorTest {

    private PresenterEnMock presenter;
    private CreateBoardGatewayMock board;
    private CreateBoardControllerInteractor interactor;
    private CreateBoardRequest request;

    @Before
    public void setUp() {
        presenter = new PresenterEnMock();
        request = new CreateBoardRequest();
    }

    @Test
    public void testBoardCreatedMessage() {
        board = new CreateBoardGatewayValidRequestStub();
        interactor = new CreateBoardInteractor(presenter, board);

        request.version = "USA";
        interactor.handle(request);

        assertTrue(board.verifyCreateMethodCalled);
        assertTrue(presenter.verifyBoardCreateMessage);
    }

    @Test
    public void testBoardPromptMessageAndAvailableBoardsMessageWithInvalidInput() {
        board = new CreateBoardGatewayInValidRequestStub();
        interactor = new CreateBoardInteractor(presenter, board);

        request.version = "TEST";
        interactor.handle(request);

        assertTrue(board.verifyIsAvailableCalled);
        assertTrue(presenter.verifyBoardPromptMessage);
        assertTrue(presenter.verifyAvailableBoardsMessage);
    }

    @Test
    public void testBoardPromptMessageAndAvailableBoardsMessageWithNullInput() {
        board = new CreateBoardGatewayInValidRequestStub();
        interactor = new CreateBoardInteractor(presenter, board);

        request.version = null;
        interactor.handle(request);

        assertTrue(board.verifyAvailableBoardsCalled);
        assertTrue(presenter.verifyBoardPromptMessage);
        assertTrue(presenter.verifyAvailableBoardsMessage);
    }
}
