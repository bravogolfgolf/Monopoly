package game.controllers;

import game.controllers.reader.Reader;
import game.controllers.writer.Writer;
import game.controllers.writerreader.WriterReader;
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
        controller = new Reader(interactor, presenter, console);

        controller.execute();
        assertTrue(console.verifyReadCalled);


        controller.handle("Valid");
        assertTrue(interactor.verifyHandleWithArgumentCalled);
        assertTrue(presenter.verifyGetFormattedMessage);
        assertTrue(console.verifyWriteCalled);
    }


    @Test
    public void testMenu() throws IOException {
        controller = new Writer(parser, interactor, presenter, console);
        controller.execute();

        assertTrue(interactor.verifyHandleWithOutArgumentCalled);
        assertTrue(presenter.verifyGetMenuMapCalled);
        assertTrue(parser.verifySetMapCalled);
        assertTrue(console.verifyWriteCalled);
    }

    @Test
    public void testWriteRead() throws IOException {
        controller = new WriterReader(interactor, presenter, console);
        controller.execute();

        assertTrue(interactor.verifyHandleWithOutArgumentCalled);
        assertTrue(presenter.verifyGetFormattedMessage);
        assertTrue(console.verifyWriteCalled);
        assertTrue(console.verifyReadCalled);
    }
}
