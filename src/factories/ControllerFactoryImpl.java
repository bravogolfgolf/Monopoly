package game.factories;

import game.Controller;
import game.ControllerFactory;
import game.controllers.Presenter;
import game.controllers.View;
import game.controllers.createPlayer.CreatePlayerController;
import game.controllers.createPlayer.CreatePlayerInteractor;
import game.controllers.setupgame.SetupGameController;
import game.controllers.setupgame.SetupGameInteractor;
import game.entitiies.Board;
import game.interactors.createplayer.CreatePlayer;
import game.interactors.createplayer.CreatePlayerGateway;
import game.interactors.setupgame.SetupGame;
import game.interactors.setupgame.SetupGameGateway;
import game.presenters.PresenterEn;
import game.repositories.PlayerRepository;
import game.view.Console;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ControllerFactoryImpl implements ControllerFactory {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final View console = new Console(reader, writer);
    private final Presenter presenter = new PresenterEn();


    @Override
    public Controller make(String controller) {
        if (controller.equals("SetupGameController")) {
            SetupGameGateway board = new Board(new BoardFactoryImpl());
            SetupGameInteractor interactor = new SetupGame(presenter, board);
            return new SetupGameController(console, interactor, presenter);
        }
        if (controller.equals("CreatePlayerController")) {
            CreatePlayerGateway repository = new PlayerRepository();
            CreatePlayerInteractor interactor = new CreatePlayer(presenter, repository);
            return new CreatePlayerController(console, interactor, presenter);
        }
        throw new IllegalArgumentException();
    }
}
