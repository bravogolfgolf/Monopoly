package usecases;

import controllers.Controller;
import controllers.ControllerFactory;
import controllers.createPlayer.CreatePlayerController;
import de.bechte.junit.runners.context.HierarchicalContextRunner;
import interactors.Interactor;
import interactors.InteractorFactory;
import interactors.createplayer.CreatePlayer;
import interactors.createplayer.CreatePlayerGateway;
import interactors.createplayer.CreatePlayerRequest;
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

import java.io.*;

import static org.junit.Assert.assertEquals;

@RunWith(HierarchicalContextRunner.class)
public class CreatePlayerTest {
    private static final String NEW_LINE = System.lineSeparator();
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
            String expected = addNewLine("Player created with Cat token.");
            String actual = ((CreatePlayerPresenterSpy) presenter).getResponse().message;
            assertEquals(expected, actual);
            assertEquals(1, repository.count());
        }

        @Test
        public void validRequestToCreatePlayerWithNonUniqueTokenFails() throws IOException {
            controller.sendRequest(request);
            controller.sendRequest(request);
            String expected = addNewLine("Token already in use.");
            String actual = ((CreatePlayerPresenterSpy) presenter).getResponse().message;
            assertEquals(expected, actual);
            assertEquals(1, repository.count());
        }

        @Test
        public void creatingMoreThanEightPlayers_ReturnsNumberOfPlayersExceededMessage() throws IOException {
            createRequestsForNinePlayers();
            String expected = addNewLine("Exceeded eight player limit.");
            String actual = ((CreatePlayerPresenterSpy) presenter).getResponse().message;
            assertEquals(expected, actual);
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
            String expected = addNewLine("Invalid request.");
            String actual = ((CreatePlayerPresenterSpy) presenter).getResponse().message;
            assertEquals(expected, actual);
            assertEquals(0, repository.count());
        }
    }

    private String addNewLine(String string) {
        return String.format(string + "%s", NEW_LINE);
    }
}
