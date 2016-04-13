package game.controllers.createBoard;

import game.Controller;
import game.controllers.ConsoleDummy;
import game.controllers.Presenter;
import game.controllers.PresenterEnDummy;
import game.controllers.View;
import game.interactors.createboard.CreateBoardGateway;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class CreateBoardControllerTest {

    @Test
    public void testCreateBoardController() throws IOException {
        View view = new ConsoleDummy();
        Presenter presenter = new PresenterEnDummy();
        CreateBoardGateway board = new CreateBoardGatewayDummy();
        CreateBoardInteractorMock interactor = new CreateBoardInteractorMock(presenter, board);
        Controller controller = new CreateBoardControllerStub(view, interactor, presenter);
        controller.execute();
        assertTrue(interactor.VerifyHandleMethodCalled);
    }
}