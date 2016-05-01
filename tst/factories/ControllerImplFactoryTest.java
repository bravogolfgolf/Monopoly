package game.factories;

import game.display.Console;
import game.manager.ControllerFactory;
import game.parser.Parser;
import game.presenters.PresenterEn;
import game.repositories.Players;
import org.junit.Before;
import org.junit.Test;

public class ControllerImplFactoryTest {

    private final Parser parser = new Parser();
    private final Console console = new Console(parser);
    private final PresenterEn presenter = new PresenterEn(console, parser);
    private final Players players = new Players();
    private final SelectVersionFactoryImpl factory = new SelectVersionFactoryImpl();

    private ControllerFactory controllerFactory;

    @Before
    public void setUp() {
        controllerFactory = new ControllerFactoryImpl(presenter, factory, players, console);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testControllerFactoryException() {
        controllerFactory.make("");
    }

    @Test
    public void testMakeController() {
        controllerFactory.make("VersionOptions");
        controllerFactory.make("TokenOptionsFewerThanMinimum");
        controllerFactory.make("TokenOptionsMinimumToMaximum");
        controllerFactory.make("Message");
        controllerFactory.make("StartTurn");
        controllerFactory.make("PropertyOptions");
        controllerFactory.make("PartnerOptions");
    }
}

