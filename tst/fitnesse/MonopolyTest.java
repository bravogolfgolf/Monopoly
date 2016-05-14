package game.fitnesse;

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

public final class MonopolyTest {

    public MonopolyTest() {
    }

    public final Parser parser = new Parser();
    public final ConsoleTest console = new ConsoleTest(parser);
    private final VersionFactory versionFactory = new VersionFactory();
    private final Banker banker = new Banker();
    final StateManager manager = new StateManager();

    public void setup(StateImpl state) throws IOException {
        final Presenter presenter = new PresenterEn(console, parser);
        final InteractorFactory interactorFactory = new InteractorFactory(presenter, versionFactory, banker, manager);
        final ControllerFactory controllerFactory = new ControllerFactory(presenter, interactorFactory, console);
        dice = new Dice();
        manager.setControllerFactory(controllerFactory);
        parser.setManager(manager);
        manager.setState(state);
    }

    public void start() throws IOException {
        manager.initialize();
    }
}
