package usecases;

import controllers.Controller;
import controllers.ControllerFactory;
import controllers.createPlayer.CreatePlayerController;
import de.bechte.junit.runners.context.HierarchicalContextRunner;
import main.ControllerFactoryImpl;
import main.InteractorFactoryImpl;
import main.PresenterFactoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import presenters.Presenter;
import presenters.PresenterFactory;
import presenters.createplayer.CreatePlayerPresenterSpy;
import repositories.PlayerRepository;
import usecases.createplayer.CreatePlayer;
import usecases.createplayer.CreatePlayerGateway;
import usecases.createplayer.CreatePlayerRequest;

import java.io.*;

import static org.junit.Assert.assertEquals;

@RunWith(HierarchicalContextRunner.class)
public class CreatePlayerTest {
    private OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
    private BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
    private InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    private CreatePlayerRequest request;
    private Presenter presenter;
    private CreatePlayerGateway repository;
    private Interactor interactor;
    private Controller controller;
    private ControllerFactory controllerFactory = new ControllerFactoryImpl();
    private InteractorFactory interactorFactory = new InteractorFactoryImpl();
    private PresenterFactory presenterFactory = new PresenterFactoryImpl();

    @Before
    public void setUpInteractor() throws Exception {
        request = new CreatePlayerRequest();
        presenter = presenterFactory.make("CreatePlayerPresenterSpy");
        ((CreatePlayerPresenterSpy) presenter).setView(bufferedWriter);
        repository = new PlayerRepository();
        interactor = interactorFactory.make("CreatePlayer");
        ((CreatePlayer) interactor).setPresenter(presenter);
        ((CreatePlayer) interactor).setGateway(repository);

        controller = controllerFactory.make("CreatePlayerController");
        ((CreatePlayerController) controller).setView(bufferedReader);
        ((CreatePlayerController) controller).setInteractor(interactor);
    }

    public class validRequestsToCreatePlayers {

        @Before
        public void setupValidRequest() {
            request.token = "Cat";
        }

        @Test
        public void validRequestToCreatePlayerWithUniqueTokenSucceeds() throws IOException {
            controller.sendRequest(request);
            assertEquals("Player created with Cat token.", ((CreatePlayerPresenterSpy) presenter).getResponse().message);
            assertEquals(1, repository.count());
        }

        @Test
        public void validRequestToCreatePlayerWithNonUniqueTokenFails() throws IOException {
            controller.sendRequest(request);
            controller.sendRequest(request);
            assertEquals("Token already in use.", ((CreatePlayerPresenterSpy) presenter).getResponse().message);
            assertEquals(1, repository.count());
        }

        @Test
        public void creatingMoreThanEightPlayers_ReturnsNumberOfPlayersExceededMessage() throws IOException {
            createRequestsForNinePlayers();
            String expectedMessage = "Exceeded eight player limit.";
            assertEquals(expectedMessage, ((CreatePlayerPresenterSpy) presenter).getResponse().message);
            assertEquals(8, repository.count());
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
            assertEquals("Invalid request.", ((CreatePlayerPresenterSpy) presenter).getResponse().message);
            assertEquals(0, repository.count());
        }
    }
}
