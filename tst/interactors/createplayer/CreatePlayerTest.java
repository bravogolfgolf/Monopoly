package game.interactors.createplayer;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import game.controllers.createPlayer.CreatePlayerInteractor;
import game.entitiies.Board;
import game.factories.SetupGameFactoryImpl;
import game.interactors.PresenterEnMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(HierarchicalContextRunner.class)
public class CreatePlayerTest {

    private final Board board = new BoardDummy();
    private final PresenterEnMock presenter = new PresenterEnMock();
    private final CreatePlayerRepositoryFake player = new CreatePlayerRepositoryFake();
    private final CreatePlayerInteractor interactor = new CreatePlayer(presenter, player);
    private final SetupGameFactoryImpl factory = new SetupGameFactoryImpl(board, player);
    private final CreatePlayerRequest request = new CreatePlayerRequest();

    @Before
    public void setUp() {
        factory.make("USA");
    }

    public class testExceedPlayerLimit {

        @Test
        public void testExceededPlayerLimit() {
            nineRequests();

            assertTrue(player.verifyPlayerLimitExceededCalled);
            assertTrue(player.verifyCreateCalled);
            assertTrue(player.verifyCreateCalledEightTimes);
            assertTrue(presenter.verifyExceededPlayerLimitMessage);
        }

        private void nineRequests() {
            String[] tokens = player.getAvailableTokens();
            for (String token : tokens) {
                request.token = token;
                interactor.handle(request);
            }
            interactor.handle(request);
        }
    }

    public class testCreatePlayer {

        @Test
        public void testPlayerCreated() {
            request.token = "Cat";
            interactor.handle(request);

            assertTrue(player.verifyPlayerLimitExceededCalled);
            assertTrue(player.verifyIsAvailableCalled);
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
            assertTrue(player.verifyIsAvailableCalled);
            assertTrue(presenter.verifyTokenInUseMessage);
            assertTrue(presenter.verifyCreatePlayerPromptMessage);
            assertTrue(player.verifyGetAvailableTokensCalled);
            assertTrue(presenter.verifyAvailableTokensMessage);
        }
    }
}