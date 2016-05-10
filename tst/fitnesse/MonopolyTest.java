package game.fitnesse;

import game.entities.Banker;
import game.factories.ControllerFactory;
import game.factories.InteractorFactory;
import game.factories.VersionFactory;
import game.manager.StateImpl;
import game.manager.StateManager;
import game.manager.StateManagerImpl;
import game.parser.Parser;
import game.presenters.Presenter;
import game.presenters.PresenterEn;

import java.io.IOException;

public final class MonopolyTest {

    public MonopolyTest() {
    }

    public final Parser parser = new Parser();
    public final ConsoleTest console = new ConsoleTest(parser);
    private final VersionFactory versionFactory = new VersionFactory();
    private final Banker banker = new Banker();
    StateManager manager;

    public void setup(StateImpl state) throws IOException {
        final Presenter presenter = new PresenterEn(console, parser);
        final InteractorFactory interactorFactory = new InteractorFactory(presenter, versionFactory, banker);
        final ControllerFactory controllerFactory = new ControllerFactory(presenter, interactorFactory, console);
        manager = new StateManagerImpl(controllerFactory);
        parser.setManager(manager);
        manager.setState(state);
    }

    public void start() throws IOException {
        manager.initialize();
    }
}
