package game;

import game.display.Console;
import game.factories.ControllerFactoryImpl;
import game.factories.SelectVersionFactoryImpl;
import game.manager.StateImpl;
import game.manager.StateManager;
import game.manager.StateManagerImpl;
import game.parser.Parser;
import game.presenters.Presenter;
import game.presenters.PresenterEn;
import game.repositories.Players;

import java.io.IOException;

final class Monopoly {

    private final Parser parser = new Parser();
    private final Console console = new Console(parser);
    private final Presenter presenter = new PresenterEn();
    private final Players players = new Players();
    private final SelectVersionFactoryImpl factory = new SelectVersionFactoryImpl();

    public static void main(String[] args) throws IOException {
        Monopoly monopoly = new Monopoly();
        monopoly.setup();
    }

    private void setup() throws IOException {
        ControllerFactoryImpl controllerFactory = new ControllerFactoryImpl(parser, presenter, factory, players, console);
        StateManager manager = new StateManagerImpl(presenter, controllerFactory, console);
        parser.setManager(manager);
        manager.setState(StateImpl.VERSION);
        manager.initialize();

    }
}