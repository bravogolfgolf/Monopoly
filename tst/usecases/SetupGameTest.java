package game.usecases;

import game.Controller;
import game.controllers.Presenter;
import game.controllers.setupgame.SetupGameInteractor;
import game.entitiies.Board;
import game.factories.SetupGameBoardGateway;
import game.factories.SetupGameFactoryImpl;
import game.interactors.setupgame.SetupGame;
import game.interactors.setupgame.SetupGameFactory;
import game.presenters.PresenterEn;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class SetupGameTest {

    @Test
    public void testCreateBoard() throws IOException {
        ConsoleMock view = new ConsoleMock();
        Presenter presenter = new PresenterEn();
        SetupGameBoardGateway board = new Board();
        SetupGameFactory factory = new SetupGameFactoryImpl(board);
        SetupGameInteractor interactor = new SetupGame(presenter, factory);
        Controller controller = new SetupGameControllerStub(view, interactor, presenter);
        String expected = "Select version of game you would like to play.\n" +
                "Available versions: (1)FRA, (2)USA\n" +
                "USA version of game created.\n";

        controller.execute();

        assertTrue(view.VerifyOutputMethodCalled(expected));
    }
}