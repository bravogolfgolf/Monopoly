package game.interactors;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import game.controllers.ControllerRequest;
import game.entities.Dice;
import game.factories.SpacesTEST;
import game.interactors.movetoken.MoveToken;
import game.interactors.partneroptions.PartnerOptions;
import game.interactors.propertyoptions.PropertyOptions;
import game.interactors.selectfirst.SelectFirst;
import game.interactors.tokenoptions.TokenOptions;
import game.interactors.tokenoptions.TokenOptionsFewerThanMinimum;
import game.interactors.tokenoptions.TokenOptionsMinimumToMaximum;
import game.interactors.versionoptions.VersionOptions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(HierarchicalContextRunner.class)
public class InteractorTest {

    private final PresenterMock presenter = new PresenterMock();
    private final SelectVersionFactoryMock factory = new SelectVersionFactoryMock();
    private final TokensMock tokens = new TokensMock();
    private final PlayersMock players = new PlayersMock();
    private final BoardMock board = new BoardMock(SpacesTEST.create());
    private final ControllerRequest request = new ControllerRequest();

    @Before
    public void setup() {
        request.string = "";
        request.dice = Dice.roll();
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

        @Test
        public void testHandleWithRequest() {
            interactor.handle(request);

            assertTrue(factory.verifyMakeCalled);
            assertTrue(presenter.verifyVersionCreatedMessage);
        }
    }

    public class TokenOptionsTest {

        private final ControllerRequest request = new ControllerRequest();

        public class TokenOptionsFewerThanMinimumTest {

            private final TokenOptions interactor = new TokenOptionsFewerThanMinimum(presenter, tokens, players);

            @Test
            public void testHandle() {
                interactor.handle();

                assertTrue(tokens.verifyGetAvailableTokensCalled);
                assertTrue(presenter.verifyCreatePlayerPromptMessageFewerThanMinimumMessage);
                assertTrue(presenter.verifyAvailableTokensMessage);
            }


            @Test
            public void testHandleWithRequest() {
                interactor.handle(request);

                assertTrue(tokens.verifyRemoveTokenCalled);
                assertTrue(players.verifyAddWithCalled);
                assertTrue(presenter.verifyPlayerCreatedMessage);
            }
        }


        public class TokenOptionsMinimumToMaximumTest {

            private final TokenOptions interactor = new TokenOptionsMinimumToMaximum(presenter, tokens, players);

            @Test
            public void testHandle() {
                interactor.handle();

                assertTrue(tokens.verifyGetAvailableTokensCalled);
                assertTrue(presenter.verifyCreatePlayerPromptMessageMinimumToMaximumMessage);
                assertTrue(presenter.verifyAvailableTokensMessage);
            }


            @Test
            public void testHandleWithRequest() {
                interactor.handle(request);

                assertTrue(tokens.verifyRemoveTokenCalled);
                assertTrue(players.verifyAddWithCalled);
                assertTrue(presenter.verifyPlayerCreatedMessage);
            }
        }
    }

    public class SelectFirstTest {

        private final SelectFirst interactor = new SelectFirst(presenter, players);

        @Test
        public void testHandle() {
            interactor.handle();

            assertTrue(players.verifyRandomizePlayersCalled);
            assertTrue(players.verifyGetCurrentPlayerCalled);
            assertTrue(presenter.verifyPlayerSelectedToGoFirstMessage);
        }
    }

    public class PropertyOptionsTest {

        private final PropertyOptions interactor = new PropertyOptions(presenter, players);

        @Test
        public void testHandle() {
            interactor.handle();

            assertTrue(players.verifyGetCurrentPlayerCalled);
            // TODO When properties are defined
            assertTrue(presenter.verifySelectPropertyPromptMessageCalled);
            assertTrue(presenter.verifyPropertyOptionsMessageCalled);
        }
    }

    public class PartnerOptionsTest {

        private final Interactor interactor = new PartnerOptions(presenter, players);

        @Test
        public void testHandle() {
            interactor.handle();

            assertTrue(presenter.verifySelectTradingPartnerPromptMessageCalled);
            assertTrue(players.verifyGetAllPlayersExceptCurrentCalled);
            assertTrue(presenter.verifyPartnerOptionsMessageCalled);
        }
    }

    public class MoveTokenTest {

        private final Interactor interactor = new MoveToken(presenter, players, board);

        @Test
        public void testMoveToken() {

            interactor.handle(request);
            assertTrue(presenter.verifyRollMessageCalled);
            assertTrue(players.verifyGetCurrentPlayerCalled);
            assertTrue(board.verifyMoveCalled);
            assertTrue(presenter.verifyMoveMessageCalled);
        }
    }
}