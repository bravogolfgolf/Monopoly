package game;

import game.doubles.ConsoleFitnesee;
import game.factories.ControllerFactory;
import game.factories.VersionFactory;
import game.manager.StateImpl;
import game.manager.StateManager;
import game.manager.StateManagerImpl;
import game.parser.Parser;
import game.presenters.Presenter;
import game.presenters.PresenterEn;
import game.repositories.Players;

import java.io.IOException;

public final class MonopolyTest {

    public static final Parser parser = new Parser();
    public static final ConsoleFitnesee console = new ConsoleFitnesee(parser);
    private final Players players = new Players();
    private final VersionFactory factory = new VersionFactory();
    private StateManager manager;

    public static void main(String[] args) throws IOException {
        MonopolyTest monopoly = new MonopolyTest();
        monopoly.setup(StateImpl.VERSION);
        monopoly.start();
    }

    private void setup(StateImpl state) throws IOException {
        final Presenter presenter = new PresenterEn(console, parser);
        final ControllerFactory controllerFactory = new ControllerFactory(presenter, factory, players, console);
        manager = new StateManagerImpl(controllerFactory);
        parser.setManager(manager);
        manager.setState(state);
    }

    private void start() throws IOException {
        manager.initialize();

    }
}