package game.preseters;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import game.controllers.Presenter;
import game.factories.SetupGameBoardGateway;
import game.factories.SetupGamePlayerGateway;
import game.interactors.createplayer.CreatePlayerGateway;
import game.interactors.setupgame.SetupGameFactory;
import game.presenters.PresenterEn;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(HierarchicalContextRunner.class)
public class PresenterEnTest {

    private final Presenter presenter = new PresenterEn();
    private String expected;

    public class setupGame {
        private final SetupGameBoardGateway board = new BoardDummy();
        private final SetupGamePlayerGateway player = new PlayerRepositoryImplDummy();
        private final SetupGameFactory factory = new SetupGameFactoryImplDummy(board, player);
        private final SetupGameStub interactor = new SetupGameStub(presenter, factory);

        @Test
        public void testVersionCreatedMessage() {
            interactor.versionCreatedMessage();
            expected = "USA version of game created.\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }

        @Test
        public void testAvailableVersionsMessage() {
            interactor.availableVersionsMessage();
            expected = "Available versions: (1)FRA, (2)USA\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }

        @Test
        public void testSetupGamePromptMessage() {
            interactor.setupGamePrompt();
            expected = "Select version of game you would like to play.\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }
    }

    public class createPlayer {
        private final CreatePlayerGateway player = new PlayerRepositoryImplDummy();
        private final CreatePlayerStub interactor = new CreatePlayerStub(presenter, player);

        @Test
        public void testCreatePlayerPrompt() {
            interactor.createPlayerPrompt();
            expected = "Please select token for player.\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }

        @Test
        public void testExceededPlayerLimitMessage() {
            interactor.exceededPlayerLimitMessage();
            expected = "Exceeded eight player limit.\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }

        @Test
        public void testPlayerCreatedMessage() {
            interactor.playerCreatedMessage();
            expected = "Player created with Cat token.\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }

        @Test
        public void testPlayerPromptMessage() {
            presenter.createPlayerPromptMessage();
            expected = "Please select token for player.\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }

        @Test
        public void testAvailableTokensMessage() {
            interactor.availableTokensMessage();
            expected = "Available tokens: (1)Automobile, (2)Battleship, (3)Boot, (4)Cat, (5)Scottish Terrier, (6)Thimble, (7)Top Hat, (8)Wheelbarrow\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }

        @Test
        public void testTokenInUseMessage() {
            interactor.tokenInUseMessage();
            expected = "Cat token already in use.\n";
            assertEquals(expected, presenter.getFormattedMessage());
        }
    }
}