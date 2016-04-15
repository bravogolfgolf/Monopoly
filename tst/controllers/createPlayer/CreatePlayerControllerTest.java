package game.controllers.createPlayer;

import game.Controller;
import game.controllers.ConsoleDummy;
import game.controllers.Presenter;
import game.controllers.PresenterEnDummy;
import game.controllers.View;
import game.interactors.createplayer.CreatePlayerGateway;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class CreatePlayerControllerTest {

    @Test
    public void testCreatePlayerController() throws IOException {
        View view = new ConsoleDummy();
        Presenter presenter = new PresenterEnDummy();
        CreatePlayerGateway repository = new CreatePlayerGatewayDummy();
        CreatePlayerMock interactor = new CreatePlayerMock(presenter, repository);
        Controller controller = new CreatePlayerControllerStub(view, interactor, presenter);
        controller.execute();
        assertTrue(interactor.verifyHandleCalled);
    }
}
