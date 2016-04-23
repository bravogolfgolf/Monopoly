package game.interactors;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import game.controllers.ControllerInteractor;
import game.interactors.createplayer.CreatePlayer;
import game.interactors.gamesetup.SelectVersion;
import game.interactors.options.Options;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(HierarchicalContextRunner.class)
public class InteractorTest {

    private final PresenterMock presenter = new PresenterMock();
    private final SelectVersionFactoryMock factory = new SelectVersionFactoryMock();
    private final PlayersMock player = new PlayersMock();
    private final InteractorRequest request = new InteractorRequest();

    public class SelectVersionTest {

        private final ControllerInteractor interactor = new SelectVersion(presenter, factory);

        @Test
        public void testHandle() {
            request.string = "Valid";
            interactor.handle(request);

            assertTrue(factory.verifyCreateMethodCalled);
            assertTrue(presenter.verifyVersionCreatedMessage);
        }

        @Test
        public void testUserInterfaceOptions() {
            interactor.userInterfaceOptions();

            assertTrue(factory.verifyGetAvailableVersionsCalled);
            assertTrue(presenter.verifyAvailableVersionsMessageCalled);
        }
    }

    public class CreatePlayerTest {

        private final ControllerInteractor interactor = new CreatePlayer(presenter, player);

        @Test
        public void testHandle() {
            request.string = "Valid";
            interactor.handle(request);

            assertTrue(player.verifyCreateCalled);
            assertTrue(presenter.verifyPlayerCreatedMessage);
        }

        @Test
        public void testUserInterfaceOptions() {
            interactor.userInterfaceOptions();

            assertTrue(player.verifyGetAvailableTokens);
            assertTrue(presenter.verifyAvailableTokensMessage);
        }
    }

    public class OptionsTest {

        private final ControllerInteractor interactor = new Options(presenter, factory, player);

        @Test(expected = IllegalArgumentException.class)
        public void testHandleInvalidRequest() {
            request.string = "Invalid";
            interactor.handle(request);
        }

        @Test
        public void testHandleVersions() {
            request.string = "Versions";
            interactor.handle(request);

            assertTrue(factory.verifyGetAvailableVersionsCalled);
            assertTrue(presenter.verifyAvailableVersionsMessageCalled);
        }

        @Test
        public void testHandleTokens() {
            request.string = "Tokens";
            interactor.handle(request);

            assertTrue(player.verifyGetAvailableTokens);
            assertTrue(presenter.verifyAvailableTokensMessage);
        }
    }
}
