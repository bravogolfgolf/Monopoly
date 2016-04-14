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

    @Test
    public void testCreateBoardController() throws IOException {
        View view = new ConsoleDummy();
        Presenter presenter = new PresenterEn();
        SetupGameBoardGateway board = new Board();
        PlayerRepositoryImpl player = new PlayerRepositoryImplDummy();
        SetupGameFactory factory = new SetupGameFactoryImpl(board, player);
        SetupGameMock interactor = new SetupGameMock(presenter, factory);
        Controller controller = new SetupGameControllerStub(view, interactor, presenter);
        controller.execute();
        assertTrue("FRA".equals(interactor.VerifyRequestValue));
    }
}