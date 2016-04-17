package game.factories;

import game.ControllerFactory;
import game.controllers.ControllerImpl;
import game.controllers.Interactor;
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
    public game.Controller make(String controller) {
        if (controller.equals("SetupGame")) {
            SetupGameFactory factory = new SetupGameFactoryImpl();
            Interactor interactor = new SetupGame(presenter, factory);
            return new ControllerImpl(console, interactor, presenter);
        }
        if (controller.equals("CreatePlayer")) {
            Interactor interactor = new CreatePlayer(presenter, playerGateway);
            return new ControllerImpl(console, interactor, presenter);
        }
        throw new IllegalArgumentException();
    }
}
