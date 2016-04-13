package game.controllers.setupgame;

import game.Controller;
import game.controllers.ConsoleDummy;
import game.controllers.Presenter;
import game.controllers.PresenterEnDummy;
import game.controllers.View;
import game.interactors.setupgame.SetupGameFactory;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class SetupGameControllerTest {

    @Test
    public void testCreateBoardController() throws IOException {
        View view = new ConsoleDummy();
        Presenter presenter = new PresenterEnDummy();
        SetupGameFactory factory = new SetupGameFactoryDummy();
        SetupGameMock interactor = new SetupGameMock(presenter, factory);
        Controller controller = new SetupGameControllerStub(view, interactor, presenter);
        controller.execute();
        assertTrue(interactor.VerifyHandleMethodCalled);
    }
}