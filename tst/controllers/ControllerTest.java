package game.controllers;

import game.manager.ManagerController;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class ControllerTest {

    private final ConsoleMock console = new ConsoleMock();
    private final ParserMock parser = new ParserMock();
    private final PresenterMock presenter = new PresenterMock();
    private final InteractorMock interactor = new InteractorMock();


    @Test
    public void testBasic() throws IOException {
        ManagerController controller = new Basic(interactor, presenter, console);
        controller.handle("Valid");

        assertTrue(interactor.verifyHandleCalled);
        assertTrue(presenter.verifyGetFormattedMessage);
        assertTrue(console.verifyWriteCalled);
    }


    @Test
    public void testSetMap() throws IOException {
        ManagerController controller = new SetMap(parser, interactor, presenter, console);
        controller.handle("Valid");

        assertTrue(interactor.verifyHandleCalled);
        assertTrue(presenter.verifyGetMenuMapCalled);
        assertTrue(parser.verifySetMapCalled);
        assertTrue(console.verifyWriteCalled);
    }
}
