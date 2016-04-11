package game.usecases;

import game.Controller;
import game.controllers.Interactor;
import game.controllers.Presenter;
import game.entitiies.Board;
import game.interactors.BoardGateway;
import game.interactors.createboard.CreateBoardInteractor;
import game.presenters.createboard.CreateBoardPresenter;
import game.utilities.StringFormatter;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateBoardTest {

    @Test
    public void testCreateBoard() throws IOException {
        ViewMock view = new ViewMock();
        Presenter presenter = new CreateBoardPresenter();
        BoardGateway gateway = new Board();
        Interactor interactor = new CreateBoardInteractor(presenter, gateway);
        Controller controller = new CreateBoardControllerFake(view, interactor, presenter);
        String expected = StringFormatter.addNewLine("Select version of board you would like to use.") +
                StringFormatter.addNewLine("USA version of board created.");

        controller.execute();
        
        assertEquals("USA", gateway.getVersion());
        assertTrue(view.VerifyOutputMethodCalled(expected));
    }
}