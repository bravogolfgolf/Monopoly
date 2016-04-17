package game.controllers;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import game.Controller;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

@RunWith(HierarchicalContextRunner.class)
public class ControllerImplTest {

    private final View view = new ConsoleDummy();
    private final PresenterMock presenter = new PresenterMock();

    public class SetupGame {

        private final SetupGameMock interactor = new SetupGameMock();

        @Test
        public void testSetupGameControllerValidNumberInput() throws IOException {
            Controller controller = new ControllerImplValidNumberInputStub(view, interactor, presenter);
            controller.execute();

            assertTrue(interactor.verifyUserInterfaceOptionsCalled);
            assertTrue(presenter.verifyGetMenuMapCalled);
            assertTrue(interactor.verifyHandleCalled);
            assertTrue(presenter.verifyGetFormattedMessageCalled);
        }

        @Test
        public void testSetupGameControllerInValidNumberInput() throws IOException {
            Controller controller = new ControllerImplInvalidNumberInputStub(view, interactor, presenter);
            controller.execute();

            assertTrue(interactor.verifyUserInterfacePromptCalled);
            assertTrue(presenter.verifyGetFormattedMessageCalled);
        }

        @Test
        public void testSetupGameControllerInValidTextInput() throws IOException {
            Controller controller = new ControllerImplInvalidTextInputStub(view, interactor, presenter);
            controller.execute();

            assertTrue(interactor.verifyUserInterfacePromptCalled);
            assertTrue(presenter.verifyGetFormattedMessageCalled);
        }
    }

    public class CreatePlayer {

        private final CreatePlayerMock interactor = new CreatePlayerMock();

        @Test
        public void testCreatePlayerControllerValidNumberInput() throws IOException {
            Controller controller = new ControllerImplValidNumberInputStub(view, interactor, presenter);
            controller.execute();

            assertTrue(interactor.verifyAvailableTokensMessage);
            assertTrue(presenter.verifyGetMenuMapCalled);
            assertTrue(interactor.verifyHandleCalled);
            assertTrue(presenter.verifyGetFormattedMessageCalled);
        }

        @Test
        public void testCreatePlayerControllerInValidNumberInput() throws IOException {
            Controller controller = new ControllerImplInvalidNumberInputStub(view, interactor, presenter);
            controller.execute();

            assertTrue(interactor.verifyCreatePlayerPrompt);
            assertTrue(presenter.verifyGetFormattedMessageCalled);
        }

        @Test
        public void testCreatePlayerControllerInValidTextInput() throws IOException {
            Controller controller = new ControllerImplInvalidTextInputStub(view, interactor, presenter);
            controller.execute();

            assertTrue(interactor.verifyCreatePlayerPrompt);
            assertTrue(presenter.verifyGetFormattedMessageCalled);
        }
    }
}
