package game.interactors.createboard;

import game.controllers.createBoard.CreateBoardInteractor;
import game.interactors.PresenterEnMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CreateBoardTest {

    private PresenterEnMock presenter;
    private CreateBoardGatewayMock board;
    private CreateBoardInteractor interactor;
    private CreateBoardRequest request;

    @Before
    public void setUp() {
        presenter = new PresenterEnMock();
        request = new CreateBoardRequest();
    }

    @Test
    public void testBoardCreatedMessage() {
        board = new CreateBoardGatewayValidRequestStub();
        interactor = new CreateBoard(presenter, board);

        request.version = "USA";
        interactor.handle(request);

        assertTrue(board.verifyCreateMethodCalled);
        assertTrue(presenter.verifyBoardCreateMessage);
    }

    @Test
    public void testBoardPromptMessageAndAvailableBoardsMessageWithInvalidInput() {
        board = new CreateBoardGatewayInValidRequestStub();
        interactor = new CreateBoard(presenter, board);

        request.version = "TEST";
        interactor.handle(request);

        assertTrue(board.verifyIsAvailableCalled);
        assertTrue(presenter.verifyBoardPromptMessage);
        assertTrue(presenter.verifyAvailableBoardsMessage);
    }

    @Test
    public void testBoardPromptMessageAndAvailableBoardsMessageWithNullInput() {
        board = new CreateBoardGatewayInValidRequestStub();
        interactor = new CreateBoard(presenter, board);

        request.version = null;
        interactor.handle(request);

        assertTrue(board.verifyAvailableBoardsCalled);
        assertTrue(presenter.verifyBoardPromptMessage);
        assertTrue(presenter.verifyAvailableBoardsMessage);
    }
}
