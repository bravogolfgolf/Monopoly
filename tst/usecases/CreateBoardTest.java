package usecases;

import controllers.Controller;
import controllers.createBoard.CreateBoardController;
import factories.BoardFactoryImpl;
import org.junit.Before;
import org.junit.Test;
import usecases.createboard.BoardFactory;
import usecases.createboard.CreateBoard;
import usecases.createboard.CreateBoardRequest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static org.junit.Assert.assertEquals;

public class CreateBoardTest {
    private OutputStreamWriter outputStreamWriter;
    private BufferedWriter bufferedWriter;

    @Before
    public void setUp() throws Exception {
        outputStreamWriter = new OutputStreamWriter(System.out);
        bufferedWriter = new BufferedWriter(outputStreamWriter);
    }

    @Test
    public void createBoard() throws IOException {
        CreateBoardPresenterSpy presenter = new CreateBoardPresenterSpy(bufferedWriter);
        BoardFactory factory = new BoardFactoryImpl();
        Interactor interactor = new CreateBoard(presenter, factory);
        Controller controller = new CreateBoardController(interactor);
        CreateBoardRequest request = new CreateBoardRequest();
        request.version = "USA";
        controller.sendRequest(request);
        assertEquals("USA version of board created.", presenter.getResponse());
    }
}
