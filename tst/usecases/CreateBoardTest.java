package usecases;

import controllers.Controller;
import controllers.createBoard.CreateBoardController;
import interactors.Interactor;
import interactors.createboard.CreateBoardInteractor;
import interactors.createboard.CreateBoardRequest;
import main.Monopoly;
import org.junit.Test;
import presenters.Presenter;
import presenters.createboard.CreateBoardPresenter;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CreateBoardTest {
    private static final String NEW_LINE = System.lineSeparator();

    @Test
    public void createBoard() throws IOException {
        Presenter presenter = Monopoly.presenterFactory.make("CreateBoardPresenter");

        Interactor interactor = Monopoly.interactorFactory.make("CreateBoardInteractor");
        ((CreateBoardInteractor) interactor).setPresenter(presenter);

        Controller controller = Monopoly.controllerFactory.make("CreateBoardController");
        ((CreateBoardController) controller).setInteractor(interactor);

        CreateBoardRequest request = new CreateBoardRequest();
        request.version = "USA";

        controller.sendRequest(request);

        String expected = addNewLine("USA version of board created.");
        String actual = ((CreateBoardPresenter) presenter).getResponse().message;
        assertEquals(expected, actual);
    }

    private String addNewLine(String string) {
        return String.format(string + "%s", NEW_LINE);
    }
}
