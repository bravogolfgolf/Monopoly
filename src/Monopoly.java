package game;

import game.display.Console;
import game.factories.ControllerFactory;
import game.factories.InteractorFactory;
import game.factories.VersionFactory;
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
    private final Players players = new Players();
    private final VersionFactory versionFactory = new VersionFactory();
    private StateManager manager;

    public static void main(String[] args) throws IOException {
        Monopoly monopoly = new Monopoly();
        monopoly.setup(StateImpl.VERSION);
        monopoly.start();
    }

    private void setup(StateImpl state) throws IOException {
        final Presenter presenter = new PresenterEn(console, parser);
        final InteractorFactory interactorFactory = new InteractorFactory(presenter, versionFactory);
        final ControllerFactory controllerFactory = new ControllerFactory(presenter, interactorFactory, players, console);
        manager = new StateManagerImpl(controllerFactory);
        parser.setManager(manager);
        manager.setState(state);
    }

    private void start() throws IOException {
        manager.initialize();

    }
}