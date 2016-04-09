package usecases;

import controllers.Controller;
import controllers.ControllerFactory;
import controllers.createBoard.CreateBoardController;
import interactors.Interactor;
import interactors.InteractorFactory;
import interactors.createboard.CreateBoard;
import interactors.createboard.CreateBoardRequest;
import main.ControllerFactoryImpl;
import main.InteractorFactoryImpl;
import main.PresenterFactoryImpl;
import org.junit.Test;
import presenters.Presenter;
import presenters.PresenterFactory;
import presenters.createboard.CreateBoardPresenterSpy;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CreateBoardTest {
    private static final String NEW_LINE = System.lineSeparator();
    private ControllerFactory controllerFactory = new ControllerFactoryImpl();
    private InteractorFactory interactorFactory = new InteractorFactoryImpl();
    private PresenterFactory presenterFactory = new PresenterFactoryImpl();

    @Test
    public void createBoard() throws IOException {
        Presenter presenter = presenterFactory.make("CreateBoardPresenterSpy");

        Interactor interactor = interactorFactory.make("CreateBoard");
        ((CreateBoard) interactor).setPresenter(presenter);

        Controller controller = controllerFactory.make("CreateBoardController");
        ((CreateBoardController) controller).setInteractor(interactor);

        CreateBoardRequest request = new CreateBoardRequest();
        request.version = "USA";

        controller.sendRequest(request);

        String expected = addNewLine("USA version of board created.");
        String actual = ((CreateBoardPresenterSpy) presenter).getResponse().message;
        assertEquals(expected, actual);
    }

    private String addNewLine(String string) {
        return String.format(string + "%s", NEW_LINE);
    }
}
