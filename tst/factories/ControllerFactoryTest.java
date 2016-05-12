package game.factories;

import game.display.Console;
import game.entities.Banker;
import game.manager.ManagerControllerFactory;
import game.manager.StateManager;
import game.parser.Parser;
import game.presenters.PresenterEn;
import org.junit.Test;

public class ControllerFactoryTest {

    private final Parser parser = new Parser();
    private final Console console = new Console(parser);
    private final PresenterEn presenter = new PresenterEn(console, parser);
    private final VersionFactory versionFactory = new VersionFactory();
    private final Banker banker = new Banker();
    private final StateManager manager = new StateManager();
    private final InteractorFactory interactorFactory = new InteractorFactory(presenter, versionFactory, banker, manager);
    private final ManagerControllerFactory controllerFactory = new ControllerFactory(presenter, interactorFactory, console);

    @Test(expected = IllegalArgumentException.class)
    public void testControllerFactoryException() {
        controllerFactory.make("");
    }

    @Test
    public void testMakeControllerWithInteractorOfType() {
        controllerFactory.make("VersionOptions");
        controllerFactory.make("TokenOptionsFewerThanMinimum");
        controllerFactory.make("TokenOptionsMinimumToMaximum");
        controllerFactory.make("Message");
        controllerFactory.make("StartTurn");
        controllerFactory.make("RollDice");
        controllerFactory.make("PassGo");
        controllerFactory.make("PropertyOptions");
        controllerFactory.make("PartnerOptions");
    }
}

