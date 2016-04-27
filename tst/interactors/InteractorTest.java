package game.interactors;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import game.controllers.basic.BasicRequest;
import game.interactors.createplayer.CreatePlayer;
import game.interactors.selectfirst.SelectFirst;
import game.interactors.selectversion.SelectVersion;
import game.interactors.startturn.StartTurn;
import game.interactors.tokenoptions.TokenOptions;
import game.interactors.tokenoptions.TokenOptionsFewerThanMinimum;
import game.interactors.tokenoptions.TokenOptionsMinimumToMaximum;
import game.interactors.versionoptions.VersionOptions;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(HierarchicalContextRunner.class)
public class InteractorTest {

    private final PresenterMock presenter = new PresenterMock();
    private final SelectVersionFactoryMock factory = new SelectVersionFactoryMock();
    private final TokensMock tokens = new TokensMock();
    private final PlayersMock player = new PlayersMock();
    private final BasicRequest request = new BasicRequest();

    public class SelectVersionTest {

        private final SelectVersion interactor = new SelectVersion(presenter, factory);

        @Test
        public void testHandle() {
            request.string = "Valid";
            interactor.handle(request);

            assertTrue(factory.verifyMakeCalled);
            assertTrue(presenter.verifyVersionCreatedMessage);
        }
    }

    public class CreatePlayerTest {

        private final CreatePlayer interactor = new CreatePlayer(presenter, tokens, player);

        @Test
        public void testHandle() {
            request.string = "Valid";
            interactor.handle(request);

            assertTrue(tokens.verifyRemoveTokenCalled);
            assertTrue(player.verifyAddWithCalled);
            assertTrue(presenter.verifyPlayerCreatedMessage);
        }
    }

    public class VersionOptionsTest {

        private final VersionOptions interactor = new VersionOptions(presenter, factory);

        @Test
        public void testHandle() {
            interactor.handle();

            assertTrue(factory.verifyGetAvailableVersionsCalled);
            assertTrue(presenter.verifySelectVersionPromptMessageCalled);
            assertTrue(presenter.verifyAvailableVersionsMessageCalled);
        }
    }

    public class TokenOptionsFewerThanMinimumTest {

        private final TokenOptions interactor = new TokenOptionsFewerThanMinimum(presenter, tokens);

        @Test
        public void testHandle() {
            interactor.handle();

            assertTrue(tokens.verifyGetAvailableTokensCalled);
            assertTrue(presenter.verifyCreatePlayerPromptMessageFewerThanMinimumMessage);
            assertTrue(presenter.verifyAvailableTokensMessage);
        }
    }

    public class TokenOptionsMinimumToMaximumTest {

        private final TokenOptions interactor = new TokenOptionsMinimumToMaximum(presenter, tokens);

        @Test
        public void testHandle() {
            interactor.handle();

            assertTrue(tokens.verifyGetAvailableTokensCalled);
            assertTrue(presenter.verifyCreatePlayerPromptMessageMinimumToMaximumMessage);
            assertTrue(presenter.verifyAvailableTokensMessage);
        }
    }

    public class SelectFirstTest {

        private final SelectFirst interactor = new SelectFirst(presenter, player);

        @Test
        public void testHandle() {
            interactor.handle();

            assertTrue(player.verifyRandomizePlayersCalled);
            assertTrue(player.verifyGetNextPlayerCalled);
            assertTrue(presenter.verifyPlayerSelectedToGoFirstMessage);
        }
    }

    public class StartTurnTest {

        private final StartTurn interactor = new StartTurn(presenter);

        @Test
        public void testHandle() {
            interactor.handle();
            assertTrue(presenter.verifyStartTurnCalled);
        }
    }
}
