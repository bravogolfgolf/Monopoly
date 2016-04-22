package game.controllers;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import game.view.Console;
import game.view.Manager;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

@RunWith(HierarchicalContextRunner.class)
public class ControllerImplTest {

    private final Manager manager = new ManagerDummy();
    private final Console console = new ConsoleDummy();

    public class SetupGame {

        private final ViewImplMock view = new ViewImplMock(console, manager);
        private final SetupGamePresenterMock presenter = new SetupGamePresenterMock();
        private final SetupGameMock interactor = new SetupGameMock();

        @Test
        public void testSetupGameControllerValidNumberInput() throws IOException {
            ControllerImpl controller = new ControllerImpl(view, interactor, presenter);
            view.setController(controller);
            controller.execute();

            assertTrue(interactor.verifyUserInterfaceOptionsCalled);
            assertTrue(presenter.verifyGetMenuMapCalled);
            assertTrue(view.verifySetMapCalled);
            assertTrue(view.verifyWriteCalled);
        }
    }

    public class CreatePlayer {

        private final ViewImplMock view = new ViewImplMock(console, manager);
        private final CreatePlayerPresenterMock presenter = new CreatePlayerPresenterMock();
        private final CreatePlayerMock interactor = new CreatePlayerMock();

        @Test
        public void testCreatePlayerControllerValidNumberInput() throws IOException {
            ControllerImpl controller = new ControllerImpl(view, interactor, presenter);
            view.setController(controller);
            controller.execute();

            assertTrue(interactor.verifyUserInterfaceOptionsCalled);
            assertTrue(presenter.verifyGetMenuMapCalled);
            assertTrue(view.verifySetMapCalled);
            assertTrue(view.verifyWriteCalled);
        }
    }
}
