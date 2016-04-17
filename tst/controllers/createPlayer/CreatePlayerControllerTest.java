package game.controllers.createPlayer;

import game.Controller;
import game.controllers.ConsoleDummy;
import game.controllers.PresenterMock;
import game.controllers.View;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class CreatePlayerControllerTest {

    private final View view = new ConsoleDummy();
    private final PresenterMock presenter = new PresenterMock();
    private final CreatePlayerMock interactor = new CreatePlayerMock();

    @Test
    public void testCreatePlayerControllerValidInput() throws IOException {
        Controller controller = new CreatePlayerControllerValidInputStub(view, interactor, presenter);
        controller.execute();

        assertTrue(interactor.verifyAvailableTokensMessage);
        assertTrue(presenter.verifyGetMenuMapCalled);
        assertTrue(interactor.verifyHandleCalled);
    }

    @Test
    public void testCreatePlayerControllerInValidInput() throws IOException {
        Controller controller = new CreatePlayerControllerInvalidInputStub(view, interactor, presenter);
        controller.execute();

        assertTrue(interactor.verifyCreatePlayerPrompt);
    }
}
