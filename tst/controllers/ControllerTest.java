package game.controllers;

import game.manager.ManagerController;
import game.view.ViewConsole;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class ControllerTest {

    private final ViewConsole console = new ConsoleDummy();
    private final ViewMock view = new ViewMock(console);
    private final PresenterMock presenter = new PresenterMock();
    private final InteractorMock interactor = new InteractorMock();


    @Test
    public void testControllerHandle() throws IOException {
        ManagerController controller = new Basic(view, interactor, presenter);
        controller.handle("Valid");

        assertTrue(interactor.verifyHandleCalled);
        assertTrue(presenter.verifyGetFormattedMessage);
        assertTrue(view.verifyWriteCalled);
    }


    @Test
    public void testSetMap() throws IOException {
        ManagerController controller = new SetMap(view, interactor, presenter);
        controller.handle("Valid");

        assertTrue(interactor.verifyUserInterfaceOptionsCalled);
        assertTrue(presenter.verifyGetMenuMapCalled);
        assertTrue(view.verifySetMapCalled);
        assertTrue(view.verifyWriteCalled);
    }
}
