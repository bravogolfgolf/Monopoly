package usecases;

import controllers.Controller;
import controllers.createPlayer.CreatePlayerController;
import de.bechte.junit.runners.context.HierarchicalContextRunner;
import interactors.Interactor;
import interactors.createplayer.CreatePlayerInteractor;
import main.PlayerGateway;
import org.junit.Test;
import org.junit.runner.RunWith;
import presenters.Presenter;
import presenters.createplayer.CreatePlayerPresenter;
import repositories.PlayerRepository;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(HierarchicalContextRunner.class)
public class CreatePlayerTest {
    private static final String NEW_LINE = System.lineSeparator();
    private final ViewMock view = new ViewMock();
    private final Presenter presenter = new CreatePlayerPresenter();
    private final PlayerGateway gateway = new PlayerRepository();
    private final Interactor interactor = new CreatePlayerInteractor(presenter, gateway);
    private final Controller controller = new CreatePlayerController(view, interactor, presenter);

    public class validRequestsToCreatePlayers {

        @Test
        public void validRequestToCreatePlayerWithUniqueTokenSucceeds() throws IOException {
            controller.handle("Cat");
            String expected = addNewLine("Player created with Cat token.");
            String actual = presenter.getViewRequest();
            assertEquals(expected, actual);
            assertEquals(1, gateway.count());
            assertTrue(view.VerifyOutputMethodCalled);
        }

        @Test
        public void validRequestToCreatePlayerWithNonUniqueTokenFails() throws IOException {
            controller.handle("Cat");
            controller.handle("Cat");
            String expected = addNewLine("Token already in use.");
            String actual = presenter.getViewRequest();
            assertEquals(expected, actual);
            assertEquals(1, gateway.count());
            assertTrue(view.VerifyOutputMethodCalled);
        }

        @Test
        public void creatingMoreThanEightPlayers_ReturnsNumberOfPlayersExceededMessage() throws IOException {
            createRequestsForNinePlayers();
            String expected = addNewLine("Exceeded eight player limit.");
            String actual = presenter.getViewRequest();
            assertEquals(expected, actual);
            assertEquals(8, gateway.count());
            assertTrue(view.VerifyOutputMethodCalled);
        }
    }

    private void createRequestsForNinePlayers() throws IOException {
        controller.handle("1");
        controller.handle("2");
        controller.handle("3");
        controller.handle("4");
        controller.handle("5");
        controller.handle("6");
        controller.handle("7");
        controller.handle("8");
        controller.handle("9");
    }

    public class invalidRequestsToCreatePlayers {

        @Test
        public void inValidRequest_ReturnsInvalidMessage() throws IOException {
            controller.handle(null);
            String expected = addNewLine("Invalid request.");
            String actual = presenter.getViewRequest();
            assertEquals(expected, actual);
            assertEquals(0, gateway.count());
            assertTrue(view.VerifyOutputMethodCalled);
        }
    }

    private String addNewLine(String string) {
        return String.format(string + "%s", NEW_LINE);
    }
}
