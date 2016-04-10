package usecases;

import controllers.Controller;
import entitiies.Board;
import interactors.BoardGateway;
import interactors.Interactor;
import interactors.createboard.CreateBoardInteractor;
import org.junit.Test;
import presenters.Presenter;
import presenters.createboard.CreateBoardPresenter;
import utilities.StringFormatter;

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