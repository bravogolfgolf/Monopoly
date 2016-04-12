package game.usecases;

import game.Controller;
import game.controllers.Interactor;
import game.controllers.Presenter;
import game.entitiies.Board;
import game.factories.BoardFactoryImpl;
import game.interactors.BoardGateway;
import game.interactors.createboard.CreateBoardInteractor;
import game.presenters.PresenterEn;
import org.junit.Test;

import java.io.IOException;

import static game.utilities.StringFormatter.addNewLine;
import static org.junit.Assert.assertTrue;

public class CreateBoardTest {

    @Test
    public void testCreateBoard() throws IOException {
        ViewMock view = new ViewMock();
        Presenter presenter = new PresenterEn();
        BoardGateway gateway = new Board(new BoardFactoryImpl());
        Interactor interactor = new CreateBoardInteractor(presenter, gateway);
        Controller controller = new CreateBoardControllerFake(view, interactor, presenter);
        String expected = addNewLine("Select versions of board you would like to use.") +
                addNewLine("Available boards: FRA, USA") +
                addNewLine("USA versions of board created.");

        controller.execute();

        assertTrue(view.VerifyOutputMethodCalled(expected));
    }
}