package controllers.createBoard;

import controllers.Controller;
import controllers.View;
import interactors.BoardGateway;
import org.junit.Test;
import presenters.Presenter;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class CreateBoardControllerTest {

    @Test
    public void testCreateBoardController() throws IOException {
        View view = new ViewDummy();
        Presenter presenter = new CreateBoardPresenterDummy();
        BoardGateway gateway = new BoardGatewayDummy();
        CreateBoardInteractorMock interactor = new CreateBoardInteractorMock(presenter, gateway);
        Controller controller = new CreateBoardControllerStub(view, interactor, presenter);
        controller.execute();
        assertTrue(interactor.VerifyHandleMethodCalled);
    }
}