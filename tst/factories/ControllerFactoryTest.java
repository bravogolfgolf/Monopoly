package game.factories;

import game.display.Console;
import game.manager.ManagerControllerFactory;
import game.parser.Parser;
import game.presenters.PresenterEn;
import game.repositories.Players;
import org.junit.Before;
import org.junit.Test;

public class ControllerFactoryTest {

    private final Parser parser = new Parser();
    private final Console console = new Console(parser);
    private final PresenterEn presenter = new PresenterEn(console, parser);
    private final Players players = new Players();
    private final VersionFactory factory = new VersionFactory();

    private ManagerControllerFactory controllerFactory;

    @Before
    public void setUp() {
        controllerFactory = new ControllerFactory(presenter, factory, players, console);
    }

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
        controllerFactory.make("MoveToken");
        controllerFactory.make("PassGo");
        controllerFactory.make("PropertyOptions");
        controllerFactory.make("PartnerOptions");
    }
}

