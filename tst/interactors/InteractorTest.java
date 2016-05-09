package game.interactors;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import game.Context;
import game.controllers.ControllerRequest;
import game.doubles.*;
import game.factories.SpacesUSA;
import game.factories.TokensUSA;
import game.interactors.movetoken.MoveToken;
import game.interactors.partneroptions.PartnerOptions;
import game.interactors.passgo.PassGo;
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

    private final ParserMock parser = new ParserMock();
    private final ConsoleMock console = new ConsoleMock(parser);
    private final PresenterMock presenter = new PresenterMock(console, parser);
    private final VersionFactoryMock factory = new VersionFactoryMock();
    private final TokensMock tokens = new TokensMock(TokensUSA.create());
    private final PlayersMock players = new PlayersMock();
    private final BoardMock board = new BoardMock(SpacesUSA.create());
    private final ControllerRequest request = new ControllerRequest();
    private final TokenMock currentPlayer = new TokenMock("Mock");
    private final BankerMock banker = new BankerMock();

    @Before
    public void setup() {
        request.string = "";
        Context.currentPlayer = currentPlayer;
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

            private final TokenOptions interactor = new TokenOptionsFewerThanMinimum(presenter, tokens, players, board);

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

                assertTrue(board.verifyFindBySpaceIDCalled);
                assertTrue(tokens.verifyRemoveTokenCalled);
                assertTrue(players.verifyAddWithCalled);
                assertTrue(presenter.verifyPlayerCreatedMessage);
            }
        }


        public class TokenOptionsMinimumToMaximumTest {

            private final TokenOptions interactor = new TokenOptionsMinimumToMaximum(presenter, tokens, players, board);

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

                assertTrue(board.verifyFindBySpaceIDCalled);
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
            assertTrue(presenter.verifyPlayerSelectedToGoFirstMessage);
        }
    }

    public class PropertyOptionsTest {

        private final PropertyOptions interactor = new PropertyOptions(presenter);

        @Test
        public void testHandle() {
            interactor.handle();

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

        private final Interactor interactor = new MoveToken(presenter, board);

        @Test
        public void testHandle() {
            interactor.handle();

            assertTrue(board.verifyMoveCalled);
            assertTrue(presenter.verifyRollMessageCalled);
        }
    }

    public class PassGOTest {

        private final Interactor interactor = new PassGo(presenter, banker, board);

        @Test
        public void testHandle() {
            interactor.handle();

            assertTrue(banker.verifyPaySalaryCalled);
            assertTrue(presenter.verifypassGOMessage);
        }
    }
}