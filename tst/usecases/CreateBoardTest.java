package usecases;

import controllers.Controller;
import controllers.createBoard.CreateBoardController;
import org.junit.Before;
import org.junit.Test;
import presenters.Presenter;
import usecases.createboard.CreateBoard;
import usecases.createboard.CreateBoardRequest;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class CreateBoardTest {
    private OutputStreamWriter outputStreamWriter;
    private BufferedWriter writer;
    private InputStreamReader inputStreamReader;
    private BufferedReader reader;

    @Before
    public void setUp() throws Exception {
        outputStreamWriter = new OutputStreamWriter(System.out);
        writer = new BufferedWriter(outputStreamWriter);

        inputStreamReader = new InputStreamReader(System.in);
        reader = new BufferedReader(inputStreamReader);

    }

    @Test
    public void createBoard() throws IOException {
        Presenter presenter = new CreateBoardPresenterSpy();
        ((CreateBoardPresenterSpy) presenter).setView(writer);

        Interactor interactor = new CreateBoard();
        ((CreateBoard) interactor).setPresenter(presenter);

        Controller controller = new CreateBoardController();
        ((CreateBoardController) controller).setView(reader);
        ((CreateBoardController) controller).setInteractor(interactor);

        CreateBoardRequest request = new CreateBoardRequest();
        request.version = "USA";

        controller.sendRequest(request);

        assertEquals("USA version of board created.", ((CreateBoardPresenterSpy) presenter).getResponse());
    }
}
