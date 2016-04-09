package usecases;

import controllers.Controller;
import controllers.View;
import controllers.createBoard.CreateBoardController;
import entitiies.Board;
import interactors.Interactor;
import interactors.createboard.CreateBoardInteractor;
import main.BoardGateway;
import org.junit.Test;
import presenters.Presenter;
import presenters.createboard.CreateBoardPresenter;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CreateBoardTest {
    private static final String NEW_LINE = System.lineSeparator();

    @Test
    public void testCreateBoard() throws IOException {
        View view = new ViewDummy();
        Presenter presenter = new CreateBoardPresenter();
        BoardGateway gateway = new Board();
        Interactor interactor = new CreateBoardInteractor(presenter, gateway);
        Controller controller = new CreateBoardController(view, interactor, presenter);

        controller.handle("USA");

        String expected = addNewLine("USA version of board created.");
        String actual = presenter.getResponse();
        assertEquals(expected, actual);
        assertEquals("USA", gateway.getVersion());
    }

    private String addNewLine(String string) {
        return String.format(string + "%s", NEW_LINE);
    }
}