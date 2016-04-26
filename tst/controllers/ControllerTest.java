package game.controllers;

import game.controllers.basic.Basic;
import game.controllers.menu.Menu;
import game.manager.ManagerBasic;
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
        ManagerBasic controller = new Basic(interactor, presenter, console);
        controller.handle("Valid");

        assertTrue(interactor.verifyHandleWithArgumentCalled);
        assertTrue(presenter.verifyGetFormattedMessage);
        assertTrue(console.verifyWriteCalled);
    }


    @Test
    public void testMenu() throws IOException {
        Menu controller = new Menu(parser, interactor, presenter, console);
        controller.execute();

        assertTrue(interactor.verifyHandleWithOutArgumentCalled);
        assertTrue(presenter.verifyGetMenuMapCalled);
        assertTrue(parser.verifySetMapCalled);
        assertTrue(console.verifyWriteCalled);
    }
}
