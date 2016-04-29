package game.controllers;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class ControllerTest {


    private final ParserMock parser = new ParserMock();
    private final ConsoleMock console = new ConsoleMock(parser);
    private final PresenterMock presenter = new PresenterMock();
    private final InteractorMock interactor = new InteractorMock();
    private Controller controller;

    @Test
    public void writerReaderHandlerExecute() throws IOException {
        controller = new SetMap(parser, interactor, presenter, console);
        controller.execute();

        assertTrue(interactor.verifyHandleWithOutArgumentCalled);
        assertTrue(presenter.verifyGetMenuMapCalled);
        assertTrue(parser.verifySetMapCalled);
        assertTrue(console.verifyWriteCalled);
        assertTrue(console.verifyReadCalled);
    }

    @Test
    public void writerReaderHandlerHandle() throws IOException {
        controller = new SetMap(parser, interactor, presenter, console);
        ((Handler) controller).handle("");

        assertTrue(interactor.verifyHandleWithArgumentCalled);
        assertTrue(presenter.verifyGetFormattedMessageCalled);
        assertTrue(console.verifyWriteCalled);
    }

    @Test
    public void writerReaderExecute() throws IOException {
        controller = new StartTurn(parser, presenter, console);
        controller.execute();

        assertTrue(presenter.verifyStartTurnMessageCalled);
        assertTrue(presenter.verifyGetFormattedMessageCalled);
        assertTrue(console.verifyWriteCalled);
    }
}
