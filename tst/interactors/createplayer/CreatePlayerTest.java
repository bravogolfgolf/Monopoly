package game.interactors.createplayer;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import game.controllers.createPlayer.CreatePlayerInteractor;
import game.interactors.PresenterEnMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(HierarchicalContextRunner.class)
public class CreatePlayerTest {

    private final PresenterEnMock presenter = new PresenterEnMock();
    private final CreatePlayerRequest request = new CreatePlayerRequest();


    public class testExceedPlayerLimit {

        private final CreatePlayerRepositoryFake player = new CreatePlayerRepositoryFake();
        private final CreatePlayerInteractor interactor = new CreatePlayer(presenter, player);

        @Test
        public void testExceededPlayerLimit() {
            sendNineRequests();

            assertTrue(player.verifyPlayerLimitExceededCalled);
            assertTrue(player.verifyCreateCalled);
            assertTrue(player.verifyCreateCalledEightTimes);
            assertTrue(presenter.verifyExceededPlayerLimitMessage);
        }
        private void sendNineRequests() {
            for (int i = 1; i < 10; i++) {
                request.token = String.format("%d", i);
                interactor.handle(request);
            }
        }
    }

    public class testCreatePlayer {

        private final CreatePlayerRepositoryMock player = new CreatePlayerRepositoryMock();
        private final CreatePlayerInteractor interactor = new CreatePlayer(presenter, player);

        @Test
        public void testPlayerCreated() {
            request.token = "Valid";
            interactor.handle(request);

            assertTrue(player.verifyPlayerLimitExceededCalled);
            assertTrue(player.verifyCreateCalled);
            assertTrue(presenter.verifyPlayerCreatedMessage);
        }

        @Test
        public void testPlayerPrompt() {
            request.token = null;
            interactor.handle(request);

            assertTrue(presenter.verifyCreatePlayerPromptMessage);
            assertTrue(presenter.verifyAvailableTokensMessage);
        }

        @Test
        public void testTokenInUse() {
            request.token = "InValid";
            interactor.handle(request);

            assertTrue(player.verifyPlayerLimitExceededCalled);
            assertTrue(player.verifyCreateCalled);
            assertTrue(presenter.verifyTokenInUseMessage);
            assertTrue(presenter.verifyCreatePlayerPromptMessage);
            assertTrue(player.verifyGetAvailableTokensCalled);
            assertTrue(presenter.verifyAvailableTokensMessage);
        }
    }
}