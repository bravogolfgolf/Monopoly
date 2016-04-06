package usecase;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import gateways.PlayerGatewaySet;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(HierarchicalContextRunner.class)
public class CreatePlayerTest {
    private CreatePlayerController controller;
    private CreatePlayerPresenterSpy presenter;
    private CreatePlayerGateway gateway;
    private CreatePlayerRequest request;
    private CreatePlayerInteractor interactor;

    @Before
    public void setUpInteractor() throws Exception {
        request = new CreatePlayerRequest();
        presenter = new CreatePlayerPresenterSpy();
        gateway = new PlayerGatewaySet();
        interactor = new CreatePlayer(presenter, gateway);
        controller = new CreatePlayerController(interactor);
    }

    public class validRequestsToCreatePlayers {

        @Before
        public void setupValidRequest() {
            request.token = "Cat";
        }

        @Test
        public void validRequestToCreatePlayerWithUniqueTokenSucceeds() {
            controller.sendRequest(request);
            assertEquals("Player created with token.", presenter.getIntendedResponse().message);
            assertEquals("Cat", presenter.getIntendedResponse().token);
            assertEquals(1, gateway.numberOfPlayers());
        }

        @Test
        public void validRequestToCreatePlayerWithNonUniqueTokenFails() {
            controller.sendRequest(request);
            controller.sendRequest(request);
            assertEquals("Token already in use.", presenter.getIntendedResponse().message);
            assertEquals(null, presenter.getIntendedResponse().token);
            assertEquals(1, gateway.numberOfPlayers());
        }

        @Test
        public void creatingMoreThanEightPlayers_ReturnsNumberOfPlayersExceededMessage() {
            createRequestsForNinePlayers();
            String expectedMessage = "Exceeded eight player limit.";
            assertEquals(expectedMessage,  presenter.getIntendedResponse().message);
            assertEquals(null, presenter.getIntendedResponse().token);
            assertEquals(8, gateway.numberOfPlayers());
        }
    }

    private void createRequestsForNinePlayers() {
        request.token = "1";
        interactor.createPlayer(request);
        request.token = "2";
        interactor.createPlayer(request);
        request.token = "3";
        interactor.createPlayer(request);
        request.token = "4";
        interactor.createPlayer(request);
        request.token = "5";
        interactor.createPlayer(request);
        request.token = "6";
        interactor.createPlayer(request);
        request.token = "7";
        interactor.createPlayer(request);
        request.token = "8";
        interactor.createPlayer(request);
        request.token = "9";
        interactor.createPlayer(request);
    }

    public class invalidRequestsToCreatePlayers {

        @Before
        public void setupInValidRequest() {
            request.token = null;
        }

        @Test
        public void inValidRequest_ReturnsInvalidMessage() {
            interactor.createPlayer(request);
            assertEquals("Invalid request.", presenter.getIntendedResponse().message);
            assertEquals(null, presenter.getIntendedResponse().token);
            assertEquals(0, gateway.numberOfPlayers());
        }
    }
}
