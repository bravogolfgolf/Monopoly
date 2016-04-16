package game.controllers.setupgame;

import game.Controller;
import game.controllers.ConsoleDummy;
import game.controllers.PresenterMock;
import game.controllers.View;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class SetupGameControllerTest {

    private final View view = new ConsoleDummy();
    private final PresenterMock presenter = new PresenterMock();
    private final SetupGameMock interactor = new SetupGameMock();

    @Test
    public void testSetupGameControllerValidInput() throws IOException {
        Controller controller = new SetupGameControllerValidInputStub(view, interactor, presenter);
        controller.execute();
        assertTrue(interactor.verifyAvailableVersionsMessageCalled);
        assertTrue(interactor.verifyHandleCalled);
    }

    @Test
    public void testSetupGameControllerInValidInput() throws IOException {
        Controller controller = new SetupGameControllerInValidInputStub(view, interactor, presenter);
        controller.execute();
        assertTrue(interactor.verifySetupGamePromptCalled);
    }
}