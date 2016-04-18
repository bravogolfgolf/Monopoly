package game.factories;

import game.Controller;
import game.controllers.ControllerImpl;
import game.controllers.Interactor;
import game.controllers.Manager;
import game.entitiies.Board;
import game.interactors.createplayer.CreatePlayer;
import game.interactors.setupgame.SetupGame;
import game.interactors.setupgame.SetupGameFactory;
import game.manager.ControllerFactory;
import game.manager.CreatePlayerManager;
import game.manager.SetupGameManager;
import game.presenters.PresenterEn;
import game.repositories.PlayerRepositoryImpl;
import game.view.Console;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static game.manager.StateImpl.PROMPT;

public class ControllerFactoryImpl implements ControllerFactory {

    static Board board;
    static PlayerRepositoryImpl playerGateway;
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final Console console = new Console(reader, writer);
    private final PresenterEn presenter = new PresenterEn();

    public Controller make(String controller) {
        if (controller.equals("SetupGame")) {
            Manager manager = new SetupGameManager(PROMPT, this);
            SetupGameFactory factory = new SetupGameFactoryImpl();
            Interactor interactor = new SetupGame(presenter, factory);
            return new ControllerImpl(console, manager, interactor, presenter);
        }
        if (controller.equals("CreatePlayer")) {
            Manager manager = new CreatePlayerManager(PROMPT, this);
            Interactor interactor = new CreatePlayer(presenter, playerGateway);
            return new ControllerImpl(console, manager, interactor, presenter);
        }
        throw new IllegalArgumentException();
    }
}
