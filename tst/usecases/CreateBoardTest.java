package usecases;

import controllers.Controller;
import controllers.ControllerFactory;
import controllers.createBoard.CreateBoardController;
import main.ControllerFactoryImpl;
import main.InteractorFactoryImpl;
import main.PresenterFactoryImpl;
import org.junit.Before;
import org.junit.Test;
import presenters.Presenter;
import presenters.PresenterFactory;
import presenters.createboard.CreateBoardPresenterSpy;
import usecases.createboard.CreateBoard;
import usecases.createboard.CreateBoardRequest;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class CreateBoardTest {
    private BufferedWriter writer;
    private BufferedReader reader;
    private ControllerFactory controllerFactory = new ControllerFactoryImpl();
    private InteractorFactory interactorFactory = new InteractorFactoryImpl();
    private PresenterFactory presenterFactory = new PresenterFactoryImpl();

    @Before
    public void setUp() throws Exception {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
        writer = new BufferedWriter(outputStreamWriter);
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        reader = new BufferedReader(inputStreamReader);
    }

    @Test
    public void createBoard() throws IOException {
        Presenter presenter = presenterFactory.make("CreateBoardPresenterSpy");
        ((CreateBoardPresenterSpy) presenter).setView(writer);

        Interactor interactor = interactorFactory.make("CreateBoard");
        ((CreateBoard) interactor).setPresenter(presenter);

        Controller controller = controllerFactory.make("CreateBoardController");
        ((CreateBoardController) controller).setView(reader);
        ((CreateBoardController) controller).setInteractor(interactor);

        CreateBoardRequest request = new CreateBoardRequest();
        request.version = "USA";

        controller.sendRequest(request);

        assertEquals("USA version of board created.", ((CreateBoardPresenterSpy) presenter).getResponse().message);
    }
}
