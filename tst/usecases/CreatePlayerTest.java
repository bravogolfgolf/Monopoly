package usecases;

import controllers.Interactor;
import controllers.Presenter;
import interactors.PlayerGateway;
import interactors.createplayer.CreatePlayerInteractor;
import main.Controller;
import org.junit.Test;
import presenters.createplayer.CreatePlayerPresenter;
import repositories.PlayerRepository;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.StringFormatter.addNewLine;

public class CreatePlayerTest {

    @Test
    public void validRequestToCreatePlayerWithUniqueTokenSucceeds() throws IOException {
        ViewMock view = new ViewMock();
        Presenter presenter = new CreatePlayerPresenter();
        PlayerGateway gateway = new PlayerRepository();
        Interactor interactor = new CreatePlayerInteractor(presenter, gateway);
        Controller controller = new CreatePlayerControllerFake(view, interactor, presenter);
        String expected = addNewLine("Please select token for player.") +
                addNewLine("Player created with Cat token.");

        controller.execute();

        assertEquals(1, gateway.count());
        assertTrue(view.VerifyOutputMethodCalled(expected));
    }
}

