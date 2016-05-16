package game.interactors;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import game.Context;
import game.controllers.ControllerRequest;
import game.doubles.*;
import game.entities.Board;
import game.factories.ControllerFactory;
import game.factories.InteractorFactory;
import game.factories.SpacesUSA;
import game.factories.TokensUSA;
import game.interactors.gotojail.GoToJail;
import game.interactors.landon.LandOn;
import game.interactors.movetoken.MoveToken;
import game.interactors.partneroptions.PartnerOptions;
import game.interactors.paysalary.PaySalary;
import game.interactors.propertyoptions.PropertyOptions;
import game.interactors.rolldice.RollDice;
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
    private final BoardFake board = new BoardFake(SpacesUSA.create());
    private final ControllerRequest request = new ControllerRequest();
    private final TokenMock currentPlayer = new TokenMock("Mock");
    private final BankerMock banker = new BankerMock();
    private final StateManagerMock manager = new StateManagerMock();
    private final InteractorFactory interactorFactory = new InteractorFactory(presenter, factory, banker, manager);
    private final ControllerFactory controllerFactory = new ControllerFactory(presenter, interactorFactory, console);

    @Before
    public void setup() {
        manager.setControllerFactory(controllerFactory);
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

                assertTrue(tokens.verifyCreateTokenCalled);
                assertTrue(board.verifySetInitialSpaceCalled);
                assertTrue(players.verifyAddCalled);
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

                assertTrue(board.verifySetInitialSpaceCalled);
                assertTrue(tokens.verifyCreateTokenCalled);
                assertTrue(players.verifyAddCalled);
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

    public class RollDiceTest {

        private final Interactor interactor = new RollDice(presenter, manager);

        @Test
        public void testHandle_NotDoubles() {
            Context.dice = new DiceRollThree();
            interactor.handle();

            assertTrue(manager.verifySetStateCalled);
            assertTrue(presenter.verifyRollMessageCalled);
        }

        @Test
        public void testHandle_Doubles() {
            Context.dice = new DiceDoubleOnes();
            interactor.handle();

            assertTrue(manager.verifySetStateCalled);
            assertTrue(presenter.verifyRollMessageCalled);
        }
    }

    public class MoveTokenTest {

        private final Interactor interactor = new MoveToken(board, manager, presenter);

        @Test
        public void testHandle_PassGo() {
            int MAKE_BOARD_FAKE_MOVE_METHOD_RETURN_TRUE = 41;
            currentPlayer.setMove(MAKE_BOARD_FAKE_MOVE_METHOD_RETURN_TRUE);
            interactor.handle();

            assertTrue(board.verifyMoveCalled);
            assertTrue(manager.verifySetStateCalled);
            assertTrue(board.verifyGetInitialSpaceDescriptionCalled);
            assertTrue(presenter.verifyPassGoMessageCalled);
        }

        @Test
        public void testHandle_NotPassGo() {
            interactor.handle();

            assertTrue(board.verifyMoveCalled);
            assertTrue(manager.verifySetStateCalled);
        }
    }

    public class PaySalaryTest {

        private final Interactor interactor = new PaySalary(presenter, banker);

        @Test
        public void testHandle() {
            interactor.handle();

            assertTrue(banker.verifyPaySalaryCalled);
            assertTrue(presenter.verifyPaySalaryMessageCalled);
        }
    }

    public class LandOnTest {

        private final Interactor interactor = new LandOn(manager, presenter);

        @Test
        public void testlandOn_Go() {
            currentPlayer.setSpace(new Board.Space.Go(0, "GO"));
            interactor.handle();

            assertTrue(manager.verifySetStateCalled);
            assertTrue(presenter.verifyLandOnMessageCalled);
        }
    }

    public class JailTest {

        private final Interactor interactor = new GoToJail(board, presenter);

        @Test
        public void testJail() {
            interactor.handle();

            assertTrue(currentPlayer.isInJail());
            assertTrue(board.verifyGetInitialSpaceDescriptionCalled);
            assertTrue(presenter.verifyGoToJailMessageCalled);
        }
    }
}