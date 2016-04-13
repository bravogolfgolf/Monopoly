package game.usecases;

import game.Controller;
import game.controllers.createPlayer.CreatePlayerInteractor;
import game.interactors.createplayer.CreatePlayer;
import game.interactors.createplayer.CreatePlayerGateway;
import game.presenters.PresenterEn;
import game.repositories.PlayerRepository;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreatePlayerTest {

    @Test
    public void validRequestToCreatePlayerWithUniqueTokenSucceeds() throws IOException {
        ConsoleMock view = new ConsoleMock();
        PresenterEn presenter = new PresenterEn();
        CreatePlayerGateway repository = new PlayerRepository();
        CreatePlayerInteractor interactor = new CreatePlayer(presenter, repository);
        Controller controller = new CreatePlayerControllerStub(view, interactor, presenter);
        String expected = "Please select tokens for player.\nPlayer created with Cat tokens.\n";

        controller.execute();

        assertEquals(1, repository.count());
        assertTrue(view.VerifyOutputMethodCalled(expected));
    }
}

