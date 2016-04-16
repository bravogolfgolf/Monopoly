package game.factories;

import game.Controller;
import game.ControllerFactory;
import game.controllers.View;
import game.controllers.createPlayer.CreatePlayerController;
import game.controllers.createPlayer.CreatePlayerInteractor;
import game.controllers.setupgame.SetupGameController;
import game.controllers.setupgame.SetupGameInteractor;
import game.entitiies.Board;
import game.interactors.createplayer.CreatePlayer;
import game.interactors.createplayer.CreatePlayerGateway;
import game.interactors.setupgame.SetupGame;
import game.interactors.setupgame.SetupGameFactory;
import game.presenters.PresenterEn;
import game.presenters.PresenterImpl;
import game.repositories.PlayerRepositoryImpl;
import game.view.Console;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ControllerFactoryImpl implements ControllerFactory {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final View console = new Console(reader, writer);
    private final PresenterImpl presenter = new PresenterEn();
    private final Board board = new Board();
    private final SetupGamePlayerGateway player = new PlayerRepositoryImpl();

    @Override
    public Controller make(String controller) {
        if (controller.equals("SetupGameController")) {
            SetupGameFactory factory = new SetupGameFactoryImpl(board, player);
            SetupGameInteractor interactor = new SetupGame(presenter, factory);
            return new SetupGameController(console, interactor, presenter);
        }
        if (controller.equals("CreatePlayerController")) {
            CreatePlayerInteractor interactor = new CreatePlayer(presenter, ((CreatePlayerGateway) player));
            return new CreatePlayerController(console, interactor, presenter);
        }
        throw new IllegalArgumentException();
    }
}
