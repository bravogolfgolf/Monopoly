package game.usecases;

import game.Controller;
import game.controllers.Interactor;
import game.controllers.InteractorPresenter;
import game.entitiies.Board;
import game.factories.BoardFactoryImpl;
import game.interactors.BoardGateway;
import game.interactors.createboard.CreateBoardInteractor;
import game.presenters.createboard.PresenterEn;
import game.utilities.StringFormatter;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class CreateBoardTest {

    @Test
    public void testCreateBoard() throws IOException {
        ViewMock view = new ViewMock();
        InteractorPresenter presenter = new PresenterEn();
        BoardGateway gateway = new Board(new BoardFactoryImpl());
        Interactor interactor = new CreateBoardInteractor(presenter, gateway);
        Controller controller = new CreateBoardControllerFake(view, interactor, presenter);
        String expected = StringFormatter.addNewLine("Select version of board you would like to use.") +
                StringFormatter.addNewLine("USA version of board created.");

        controller.execute();
        
        assertTrue(view.VerifyOutputMethodCalled(expected));
    }
}