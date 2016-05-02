package game.controllers;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import game.doubles.ConsoleMock;
import game.doubles.InteractorMock;
import game.doubles.ParserMock;
import game.doubles.PresenterMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

@RunWith(HierarchicalContextRunner.class)
public class ControllerTest {

    private final ParserMock parser = new ParserMock();
    private final ConsoleMock console = new ConsoleMock(parser);
    private final PresenterMock presenter = new PresenterMock(console, parser);
    private final InteractorMock interactor = new InteractorMock();
    private Controller controller;

    public class HandlerTest {

        @Test
        public void execute() throws IOException {
            controller = new Options(interactor, presenter, console);
            controller.execute();

            assertTrue(interactor.verifyHandleWithOutArgumentCalled);
            assertTrue(presenter.verifyWriteMessageCalled);
            assertTrue(console.verifyReadCalled);
        }

        @Test
        public void handle() throws IOException {
            controller = new Options(interactor, presenter, console);
            ((Options) controller).handle("");

            assertTrue(interactor.verifyHandleWithArgumentCalled);
            assertTrue(presenter.verifyWriteMessageCalled);
        }
    }

    public class StartTurnTest {

        @Test
        public void execute() throws IOException {
            controller = new StartTurn(presenter, console);
            controller.execute();

            assertTrue(presenter.verifyStartTurnMessageCalled);
            assertTrue(presenter.verifyWriteMessageCalled);
        }
    }

    public class MessageTest {

        @Test
        public void execute() throws IOException {
            controller = new Message(interactor, presenter);
            controller.execute();

            assertTrue(interactor.verifyHandleWithOutArgumentCalled);
            assertTrue(presenter.verifyWriteMessageCalled);
        }
    }

    public class MoveTest {

        @Test
        public void execute() throws IOException {
            controller = new Move(interactor, presenter);
            controller.execute();

            assertTrue(interactor.verifyHandleWithOutArgumentCalled);
            assertTrue(presenter.verifyWriteMessageCalled);
        }
    }
}