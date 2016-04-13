package game.usecases;

import game.Controller;
import game.controllers.Presenter;
import game.controllers.createBoard.CreateBoardInteractor;
import game.entitiies.Board;
import game.factories.BoardFactoryImpl;
import game.interactors.createboard.CreateBoard;
import game.interactors.createboard.CreateBoardGateway;
import game.presenters.PresenterEn;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class CreateBoardTest {

    @Test
    public void testCreateBoard() throws IOException {
        ConsoleMock view = new ConsoleMock();
        Presenter presenter = new PresenterEn();
        CreateBoardGateway board = new Board(new BoardFactoryImpl());
        CreateBoardInteractor interactor = new CreateBoard(presenter, board);
        Controller controller = new CreateBoardControllerStub(view, interactor, presenter);
        String expected = "Select versions of board you would like to use.\n" +
                "Available boards: FRA, USA\n" +
                "USA version of board created.\n";

        controller.execute();

        assertTrue(view.VerifyOutputMethodCalled(expected));
    }
}