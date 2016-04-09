package usecases;

import controllers.Controller;
import controllers.createPlayer.CreatePlayerController;
import de.bechte.junit.runners.context.HierarchicalContextRunner;
import interactors.Interactor;
import interactors.createplayer.CreatePlayerGateway;
import interactors.createplayer.CreatePlayerInteractor;
import interactors.createplayer.CreatePlayerRequest;
import main.Monopoly;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import presenters.Presenter;
import presenters.createplayer.CreatePlayerPresenter;
import repositories.PlayerRepository;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(HierarchicalContextRunner.class)
public class CreatePlayerTest {
    private static final String NEW_LINE = System.lineSeparator();
    private CreatePlayerRequest request;
    private Presenter presenter;
    private CreatePlayerGateway repository;
    private Interactor interactor;
    private Controller controller;

    @Before
    public void setUpInteractor() throws Exception {
        request = new CreatePlayerRequest();
        presenter = Monopoly.presenterFactory.make("CreatePlayerPresenter");

        repository = new PlayerRepository();
        interactor = Monopoly.interactorFactory.make("CreatePlayerInteractor");
        ((CreatePlayerInteractor) interactor).setPresenter(presenter);
        ((CreatePlayerInteractor) interactor).setGateway(repository);

        controller = Monopoly.controllerFactory.make("CreatePlayerController");
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
            String actual = ((CreatePlayerPresenter) presenter).getResponse().message;
            assertEquals(expected, actual);
            assertEquals(1, repository.count());
        }

        @Test
        public void validRequestToCreatePlayerWithNonUniqueTokenFails() throws IOException {
            controller.sendRequest(request);
            controller.sendRequest(request);
            String expected = addNewLine("Token already in use.");
            String actual = ((CreatePlayerPresenter) presenter).getResponse().message;
            assertEquals(expected, actual);
            assertEquals(1, repository.count());
        }

        @Test
        public void creatingMoreThanEightPlayers_ReturnsNumberOfPlayersExceededMessage() throws IOException {
            createRequestsForNinePlayers();
            String expected = addNewLine("Exceeded eight player limit.");
            String actual = ((CreatePlayerPresenter) presenter).getResponse().message;
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
            String actual = ((CreatePlayerPresenter) presenter).getResponse().message;
            assertEquals(expected, actual);
            assertEquals(0, repository.count());
        }
    }

    private String addNewLine(String string) {
        return String.format(string + "%s", NEW_LINE);
    }
}
