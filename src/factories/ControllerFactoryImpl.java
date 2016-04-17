package game.factories;

import game.Controller;
import game.ControllerFactory;
import game.controllers.createPlayer.CreatePlayerController;
import game.controllers.createPlayer.CreatePlayerInteractor;
import game.controllers.setupgame.SetupGameController;
import game.controllers.setupgame.SetupGameInteractor;
import game.interactors.createplayer.CreatePlayer;
import game.interactors.setupgame.SetupGame;
import game.interactors.setupgame.SetupGameFactory;
import game.presenters.PresenterEn;
import game.view.Console;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static game.Context.playerGateway;

public class ControllerFactoryImpl implements ControllerFactory {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final Console console = new Console(reader, writer);
    private final PresenterEn presenter = new PresenterEn();

    @Override
    public Controller make(String controller) {
        if (controller.equals("SetupGameController")) {
            SetupGameFactory factory = new SetupGameFactoryImpl();
            SetupGameInteractor interactor = new SetupGame(presenter, factory);
            return new SetupGameController(console, interactor, presenter);
        }
        if (controller.equals("CreatePlayerController")) {
            CreatePlayerInteractor interactor = new CreatePlayer(presenter, playerGateway);
            return new CreatePlayerController(console, interactor, presenter);
        }
        throw new IllegalArgumentException();
    }
}
