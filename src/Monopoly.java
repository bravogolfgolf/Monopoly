package game;

import game.display.Console;
import game.factories.ControllerFactoryImpl;
import game.factories.SelectVersionFactoryImpl;
import game.manager.StateImpl;
import game.manager.StateManager;
import game.manager.StateManagerImpl;
import game.presenters.PresenterEn;
import game.repositories.Players;
import game.view.View;

import java.io.*;

final class Monopoly {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final Console console = new Console(reader, writer);

    public static void main(String[] args) throws IOException {
        Monopoly monopoly = new Monopoly();
        monopoly.setup();
    }

    private void setup() throws IOException {
        View view = new View(console);
        PresenterEn presenter = new PresenterEn();
        Players players = new Players();
        SelectVersionFactoryImpl factory = new SelectVersionFactoryImpl();
        ControllerFactoryImpl controllerFactory = new ControllerFactoryImpl(view, presenter, factory, players);
        StateManager manager = new StateManagerImpl(view, presenter, controllerFactory);
        manager.setState(StateImpl.VERSION);
        manager.initialize();

    }
}