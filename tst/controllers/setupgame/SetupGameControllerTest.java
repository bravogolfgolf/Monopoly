package game.controllers.setupgame;

import game.Controller;
import game.controllers.ConsoleDummy;
import game.controllers.Presenter;
import game.controllers.View;
import game.entitiies.Board;
import game.factories.SetupGameBoardGateway;
import game.factories.SetupGameFactoryImpl;
import game.interactors.setupgame.SetupGameFactory;
import game.presenters.PresenterEn;
import game.repositories.PlayerRepositoryImpl;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class SetupGameControllerTest {

    private final View view = new ConsoleDummy();
    private final Presenter presenter = new PresenterEn();
    private final SetupGameBoardGateway board = new Board();
    private final PlayerRepositoryImpl player = new PlayerRepositoryImplDummy();
    private final SetupGameFactory factory = new SetupGameFactoryImpl(board, player);
    private final SetupGameMock interactor = new SetupGameMock(presenter, factory);

    @Test
    public void testSetupGameControllerValidInput() throws IOException {
        Controller controller = new SetupGameControllerValidInputStub(view, interactor, presenter);
        controller.execute();
        assertTrue(interactor.verifyAvailableVersionsMessageCalled);
        assertTrue(interactor.verifyHandleCalled);
    }

    @Test
    public void testSetupGameControllerInValidInput() throws IOException {
        Controller controller = new SetupGameControllerInValidInputStub(view, interactor, presenter);
        controller.execute();
        assertTrue(interactor.verifySetupGamePromptCalled);
    }
}