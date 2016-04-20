package game.controllers;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import game.view.Console;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(HierarchicalContextRunner.class)
public class ControllerImplTest {

    private final Manager manager = new ManagerDummy();
    private final Console console = new ConsoleDummy();

    public class SetupGame {

        private final SetupGameViewMock view = new SetupGameViewMock(console, manager);
        private final SetupGamePresenterMock presenter = new SetupGamePresenterMock();
        private final SetupGameMock interactor = new SetupGameMock();

        @Test
        public void testSetupGameControllerValidNumberInput() throws IOException {
            ControllerImpl controller = new ControllerImpl(view, interactor, presenter);
            view.setController(controller);
            controller.execute();

            assertTrue(view.verifyUserInterfacePromptCalled);
            assertTrue(interactor.verifyUserInterfaceOptionsCalled);
            assertTrue(presenter.verifyGetMenuMapCalled);
            assertTrue(view.verifySetMapCalled);
            assertTrue(view.verifyWriteCalled);
            assertTrue(interactor.verifyHandleCalled);
            assertEquals(2, presenter.verifyGetFormattedMessageCalledCount);
        }
    }

    public class CreatePlayer {

        private final CreatePlayerViewMock view = new CreatePlayerViewMock(console, manager);
        private final CreatePlayerPresenterMock presenter = new CreatePlayerPresenterMock();
        private final CreatePlayerMock interactor = new CreatePlayerMock();

        @Test
        public void testCreatePlayerControllerValidNumberInput() throws IOException {
            ControllerImpl controller = new ControllerImpl(view, interactor, presenter);
            view.setController(controller);
            controller.execute();

            assertTrue(view.verifyUserInterfacePromptCalled);
            assertTrue(interactor.verifyUserInterfaceOptionsCalled);
            assertTrue(presenter.verifyGetMenuMapCalled);
            assertTrue(view.verifySetMapCalled);
            assertTrue(view.verifyWriteCalled);
            assertTrue(interactor.verifyHandleCalled);
            assertEquals(2, presenter.verifyGetFormattedMessageCalledCount);
        }
    }
}
