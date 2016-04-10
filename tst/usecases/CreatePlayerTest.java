package usecases;

import controllers.Controller;
import interactors.Interactor;
import interactors.createplayer.CreatePlayerInteractor;
import main.PlayerGateway;
import org.junit.Test;
import presenters.Presenter;
import presenters.createplayer.CreatePlayerPresenter;
import repositories.PlayerRepository;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreatePlayerTest {
    private static final String NEW_LINE = System.lineSeparator();

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

    private String addNewLine(String string) {
        return String.format(string + "%s", NEW_LINE);
    }
}

