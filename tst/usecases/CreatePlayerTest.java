package game.usecases;

import game.Controller;
import game.controllers.Interactor;
import game.interactors.PlayerGateway;
import game.interactors.createplayer.CreatePlayerInteractor;
import game.presenters.PresenterEn;
import game.repositories.PlayerRepository;
import org.junit.Test;

import java.io.IOException;

import static game.utilities.StringFormatter.addNewLine;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreatePlayerTest {

    @Test
    public void validRequestToCreatePlayerWithUniqueTokenSucceeds() throws IOException {
        ViewMock view = new ViewMock();
        PresenterEn presenter = new PresenterEn();
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

