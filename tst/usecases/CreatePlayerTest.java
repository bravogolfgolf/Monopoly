package game.usecases;

import game.Controller;
import game.controllers.createPlayer.CreatePlayerControllerInteractor;
import game.interactors.createplayer.CreatePlayerGateway;
import game.interactors.createplayer.CreatePlayerInteractor;
import game.presenters.PresenterEn;
import game.repositories.CreatePlayerRepository;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreatePlayerTest {

    @Test
    public void validRequestToCreatePlayerWithUniqueTokenSucceeds() throws IOException {
        ConsoleMock view = new ConsoleMock();
        PresenterEn presenter = new PresenterEn();
        CreatePlayerGateway repository = new CreatePlayerRepository();
        CreatePlayerControllerInteractor interactor = new CreatePlayerInteractor(presenter, repository);
        Controller controller = new CreatePlayerControllerFake(view, interactor, presenter);
        String expected = "Please select tokens for player.\nPlayer created with Cat tokens.\n";

        controller.execute();

        assertEquals(1, repository.count());
        assertTrue(view.VerifyOutputMethodCalled(expected));
    }
}

