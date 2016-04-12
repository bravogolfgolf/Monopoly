package game.controllers.createPlayer;

import game.Controller;
import game.controllers.Presenter;
import game.controllers.PresenterEnDummy;
import game.controllers.View;
import game.controllers.ViewDummy;
import game.interactors.PlayerGateway;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class CreatePlayerControllerTest {

    @Test
    public void testCreatePlayerController() throws IOException {
        View view = new ViewDummy();
        Presenter presenter = new PresenterEnDummy();
        PlayerGateway gateway = new PlayerGatewayDummy();
        CreatePlayerInteractorMock interactor = new CreatePlayerInteractorMock(presenter, gateway);
        Controller controller = new CreatePlayerControllerStub(view, interactor, presenter);
        controller.execute();
        assertTrue(interactor.VerifyHandleMethodCalled);
    }
}
