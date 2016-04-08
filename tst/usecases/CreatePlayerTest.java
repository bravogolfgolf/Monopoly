package usecases;

import controllers.Controller;
import controllers.createPlayer.CreatePlayerController;
import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import repositories.PlayerRepository;
import usecases.createplayer.CreatePlayer;
import usecases.createplayer.CreatePlayerGateway;
import usecases.createplayer.CreatePlayerRequest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static org.junit.Assert.assertEquals;

@RunWith(HierarchicalContextRunner.class)
public class CreatePlayerTest {
    private OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
    private BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
    private CreatePlayerRequest request;
    private CreatePlayerPresenterSpy presenter;
    private CreatePlayerGateway gateway;
    private Interactor interactor;
    private Controller controller;

    @Before
    public void setUpInteractor() throws Exception {
        request = new CreatePlayerRequest();
        presenter = new CreatePlayerPresenterSpy(bufferedWriter);
        gateway = new PlayerRepository();
        interactor = new CreatePlayer(presenter, gateway);
        controller = new CreatePlayerController(interactor);
    }

    public class validRequestsToCreatePlayers {

        @Before
        public void setupValidRequest() {
            request.token = "Cat";
        }

        @Test
        public void validRequestToCreatePlayerWithUniqueTokenSucceeds() throws IOException {
            controller.sendRequest(request);
            assertEquals("Player created with Cat token.", presenter.getResponse().message);
            assertEquals(1, gateway.count());
        }

        @Test
        public void validRequestToCreatePlayerWithNonUniqueTokenFails() throws IOException {
            controller.sendRequest(request);
            controller.sendRequest(request);
            assertEquals("Token already in use.", presenter.getResponse().message);
            assertEquals(1, gateway.count());
        }

        @Test
        public void creatingMoreThanEightPlayers_ReturnsNumberOfPlayersExceededMessage() throws IOException {
            createRequestsForNinePlayers();
            String expectedMessage = "Exceeded eight player limit.";
            assertEquals(expectedMessage, presenter.getResponse().message);
            assertEquals(8, gateway.count());
        }
    }

    private void createRequestsForNinePlayers() throws IOException {
        request.token = "1";
        interactor.handle(request);
        request.token = "2";
        interactor.handle(request);
        request.token = "3";
        interactor.handle(request);
        request.token = "4";
        interactor.handle(request);
        request.token = "5";
        interactor.handle(request);
        request.token = "6";
        interactor.handle(request);
        request.token = "7";
        interactor.handle(request);
        request.token = "8";
        interactor.handle(request);
        request.token = "9";
        interactor.handle(request);
    }

    public class invalidRequestsToCreatePlayers {

        @Before
        public void setupInValidRequest() {
            request.token = null;
        }

        @Test
        public void inValidRequest_ReturnsInvalidMessage() throws IOException {
            interactor.handle(request);
            assertEquals("Invalid request.", presenter.getResponse().message);
            assertEquals(0, gateway.count());
        }
    }
}
