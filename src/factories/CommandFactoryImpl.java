package game.factories;

import game.Command;
import game.controllers.ControllerImpl;
import game.display.ConsoleImpl;
import game.entities.Board;
import game.interactors.createplayer.CreatePlayer;
import game.interactors.setupgame.SetupGame;
import game.manager.ControllerFactory;
import game.manager.UIManager;
import game.manager.UIManagerImpl;
import game.manager.UIStateImpl;
import game.presenters.PresenterEn;
import game.repositories.PlayerRepositoryImpl;
import game.view.CreatePlayerView;
import game.view.SetupGameView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CommandFactoryImpl implements ControllerFactory {

    static Board board;
    static PlayerRepositoryImpl playerGateway;
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final ConsoleImpl console = new ConsoleImpl(reader, writer);
    private final PresenterEn presenter = new PresenterEn();
    private final UIManager manager = new UIManagerImpl(presenter, this);

    public Command make(String controller, UIStateImpl stateUI) {
        if (controller.equals("SetupGame")) {
            setUIState(stateUI);
            SetupGameView view = new SetupGameView(console, manager);
            SetupGameFactoryImpl factory = new SetupGameFactoryImpl();
            SetupGame interactor = new SetupGame(presenter, factory);
            ControllerImpl command = new ControllerImpl(view, interactor, presenter);
            view.setController(command);
            return command;
        }
        if (controller.equals("CreatePlayer")) {
            setUIState(stateUI);
            CreatePlayerView view = new CreatePlayerView(console, manager);
            CreatePlayer interactor = new CreatePlayer(presenter, playerGateway);
            ControllerImpl command = new ControllerImpl(view, interactor, presenter);
            view.setController(command);
            return command;
        }
        throw new IllegalArgumentException();
    }

    private void setUIState(UIStateImpl stateUI) {
        manager.setUiState(stateUI);
    }
}
