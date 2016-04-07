package usecases;

import factories.BoardFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateBoardTest {

    private CreateBoardPresenterSpy presenter;
    private Factory factory;
    private Interactor interactor;
    private Controller controller;
    private CreateBoardRequest request;

    @Before
    public void setup() {
        presenter = new CreateBoardPresenterSpy();
        factory = new BoardFactory();
        interactor = new CreateBoard(presenter, factory);
        controller = new CreateBoardController(interactor);
        request = new CreateBoardRequest();
        request.version = "USA";
    }

    @Test
    public void createBoard() {
        controller.sendRequest(request);
        assertEquals("USA version of board created.",presenter.getIntendedResponse().message);
    }
}
