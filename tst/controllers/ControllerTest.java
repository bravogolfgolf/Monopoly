package game.controllers;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import game.doubles.ConsoleMock;
import game.doubles.InteractorMock;
import game.doubles.ParserMock;
import game.doubles.PresenterMock;
import game.entities.Dice;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

@RunWith(HierarchicalContextRunner.class)
public class ControllerTest {

    private final ParserMock parser = new ParserMock();
    private final ConsoleMock console = new ConsoleMock(parser);
    private final PresenterMock presenter = new PresenterMock();
    private final InteractorMock interactor = new InteractorMock();
    private Controller controller;

    public class HandlerTest {

        @Test
        public void execute() throws IOException {
            controller = new Options(parser, interactor, presenter, console);
            controller.execute();

            assertTrue(interactor.verifyHandleWithOutArgumentCalled);
            assertTrue(presenter.verifyGetMenuMapCalled);
            assertTrue(parser.verifySetMapCalled);
            assertTrue(console.verifyWriteCalled);
            assertTrue(console.verifyReadCalled);
        }

        @Test
        public void handle() throws IOException {
            controller = new Options(parser, interactor, presenter, console);
            ((Options) controller).handle("");

            assertTrue(interactor.verifyHandleWithArgumentCalled);
            assertTrue(presenter.verifyGetFormattedMessageCalled);
            assertTrue(console.verifyWriteCalled);
        }
    }

    public class StartTurnTest {

        @Test
        public void execute() throws IOException {
            controller = new StartTurn(parser, presenter, console);
            controller.execute();

            assertTrue(parser.verifyClearMapCalled);
            assertTrue(presenter.verifyStartTurnMessageCalled);
            assertTrue(presenter.verifyGetFormattedMessageCalled);
            assertTrue(console.verifyWriteCalled);
        }
    }

    public class MessageTest {

        @Test
        public void execute() throws IOException {
            controller = new Message(interactor, presenter, console);
            controller.execute();

            assertTrue(interactor.verifyHandleWithOutArgumentCalled);
            assertTrue(presenter.verifyGetFormattedMessageCalled);
            assertTrue(console.verifyWriteCalled);
        }
    }

    public class MoveTest {

        @Test
        public void execute() throws IOException {
            Dice dice = Dice.roll();
            controller = new Move(interactor, presenter, console, dice);
            controller.execute();

            assertTrue(interactor.verifyHandleWithArgumentCalled);
            assertTrue(presenter.verifyGetFormattedMessageCalled);
            assertTrue(console.verifyWriteCalled);
        }
    }
}