package game;

import game.display.Console;
import game.entities.Banker;
import game.entities.Dice;
import game.factories.ControllerFactory;
import game.factories.InteractorFactory;
import game.factories.VersionFactory;
import game.manager.StateImpl;
import game.manager.StateManager;
import game.parser.Parser;
import game.presenters.Presenter;
import game.presenters.PresenterEn;

import java.io.IOException;

import static game.Context.dice;

final class Monopoly {

    private final Parser parser = new Parser();
    private final Console console = new Console(parser);
    private final VersionFactory versionFactory = new VersionFactory();
    private final Banker banker = new Banker();
    private final StateManager manager = new StateManager();

    public static void main(String[] args) throws IOException {
        Monopoly monopoly = new Monopoly();
        monopoly.setup(StateImpl.VERSION);
        monopoly.start();
    }

    private void setup(StateImpl state) throws IOException {
        final Presenter presenter = new PresenterEn(console, parser);
        final InteractorFactory interactorFactory = new InteractorFactory(presenter, versionFactory, banker, manager);
        final ControllerFactory controllerFactory = new ControllerFactory(presenter, interactorFactory, console);
        dice = new Dice();
        manager.setFactory(controllerFactory);
        parser.setManager(manager);
        manager.setState(state);
    }

    private void start() throws IOException {
        manager.initialize();

    }
}