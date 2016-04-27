package game.controllers;

import game.controllers.basic.Basic;
import game.controllers.menu.Menu;
import game.controllers.writeread.WriteRead;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class ControllerTest {

    private final ConsoleMock console = new ConsoleMock();
    private final ParserMock parser = new ParserMock();
    private final PresenterMock presenter = new PresenterMock();
    private final InteractorMock interactor = new InteractorMock();
    private Controller controller;


    @Test
    public void testBasic() throws IOException {
        controller = new Basic(interactor, presenter, console);

        controller.execute();
        assertTrue(console.verifyReadCalled);


        controller.handle("Valid");
        assertTrue(interactor.verifyHandleWithArgumentCalled);
        assertTrue(presenter.verifyGetFormattedMessage);
        assertTrue(console.verifyWriteCalled);
    }


    @Test
    public void testMenu() throws IOException {
        controller = new Menu(parser, interactor, presenter, console);
        controller.execute();

        assertTrue(interactor.verifyHandleWithOutArgumentCalled);
        assertTrue(presenter.verifyGetMenuMapCalled);
        assertTrue(parser.verifySetMapCalled);
        assertTrue(console.verifyWriteCalled);
    }

    @Test
    public void testWriteRead() throws IOException {
        controller = new WriteRead(interactor, presenter, console);
        controller.execute();

        assertTrue(interactor.verifyHandleWithOutArgumentCalled);
        assertTrue(presenter.verifyGetFormattedMessage);
        assertTrue(console.verifyWriteCalled);
        assertTrue(console.verifyReadCalled);
    }
}
