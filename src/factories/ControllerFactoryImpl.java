package game.factories;

import game.Command;
import game.controllers.ControllerImpl;
import game.controllers.Interactor;
import game.controllers.View;
import game.display.ConsoleImpl;
import game.entitiies.Board;
import game.interactors.createplayer.CreatePlayer;
import game.interactors.setupgame.SetupGame;
import game.interactors.setupgame.SetupGameFactory;
import game.manager.ControllerFactory;
import game.manager.CreatePlayerManager;
import game.manager.SetupGameManager;
import game.presenters.PresenterEn;
import game.repositories.PlayerRepositoryImpl;
import game.view.CreatePlayerView;
import game.view.Manager;
import game.view.SetupGameView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static game.manager.StateImpl.SETUP_GAME;

public class ControllerFactoryImpl implements ControllerFactory {

    static Board board;
    static PlayerRepositoryImpl playerGateway;
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final ConsoleImpl console = new ConsoleImpl(reader, writer);
    private final PresenterEn presenter = new PresenterEn();

    public Command make(String controller) {
        if (controller.equals("SetupGame")) {
            Manager manager = new SetupGameManager(SETUP_GAME, this);
            View view = new SetupGameView(console, manager);
            SetupGameFactory factory = new SetupGameFactoryImpl();
            Interactor interactor = new SetupGame(presenter, factory);
            ControllerImpl command = new ControllerImpl(view, interactor, presenter);
            view.setController(command);
            return command;
        }
        if (controller.equals("CreatePlayer")) {
            Manager manager = new CreatePlayerManager(SETUP_GAME, this);
            View view = new CreatePlayerView(console, manager);
            Interactor interactor = new CreatePlayer(presenter, playerGateway);
            ControllerImpl command = new ControllerImpl(view, interactor, presenter);
            view.setController(command);
            return command;
        }
        throw new IllegalArgumentException();
    }
}
