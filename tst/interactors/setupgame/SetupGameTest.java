package game.interactors.setupgame;

import game.controllers.setupgame.SetupGameInteractor;
import game.interactors.PresenterEnMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SetupGameTest {

    private PresenterEnMock presenter;
    private SetupGameGatewayMock board;
    private SetupGameInteractor interactor;
    private SetupGameRequest request;

    @Before
    public void setUp() {
        presenter = new PresenterEnMock();
        request = new SetupGameRequest();
    }

    @Test
    public void testBoardCreatedMessage() {
        board = new SetupGameGatewayValidRequestStub();
        interactor = new SetupGame(presenter, board);

        request.version = "USA";
        interactor.handle(request);

        assertTrue(board.verifyCreateMethodCalled);
        assertTrue(presenter.verifyBoardCreateMessage);
    }

    @Test
    public void testBoardPromptMessageAndAvailableBoardsMessageWithInvalidInput() {
        board = new SetupGameGatewayInValidRequestStub();
        interactor = new SetupGame(presenter, board);

        request.version = "TEST";
        interactor.handle(request);

        assertTrue(board.verifyIsAvailableCalled);
        assertTrue(presenter.verifyBoardPromptMessage);
        assertTrue(presenter.verifyAvailableBoardsMessage);
    }

    @Test
    public void testBoardPromptMessageAndAvailableBoardsMessageWithNullInput() {
        board = new SetupGameGatewayInValidRequestStub();
        interactor = new SetupGame(presenter, board);

        request.version = null;
        interactor.handle(request);

        assertTrue(board.verifyAvailableBoardsCalled);
        assertTrue(presenter.verifyBoardPromptMessage);
        assertTrue(presenter.verifyAvailableBoardsMessage);
    }
}
