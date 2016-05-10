package game.factories;

import game.display.Console;
import game.entities.Banker;
import game.manager.ManagerControllerFactory;
import game.parser.Parser;
import game.presenters.PresenterEn;
import org.junit.Test;

public class ControllerFactoryTest {

    private final Parser parser = new Parser();
    private final Console console = new Console(parser);
    private final PresenterEn presenter = new PresenterEn(console, parser);
    private final VersionFactory versionFactory = new VersionFactory();
    private final Banker banker = new Banker();
    private final InteractorFactory interactorFactory = new InteractorFactory(presenter, versionFactory, banker);
    private final ManagerControllerFactory factory = new ControllerFactory(presenter, interactorFactory, console);

    @Test(expected = IllegalArgumentException.class)
    public void testControllerFactoryException() {
        factory.make("");
    }

    @Test
    public void testMakeControllerWithInteractorOfType() {
        factory.make("VersionOptions");
        factory.make("TokenOptionsFewerThanMinimum");
        factory.make("TokenOptionsMinimumToMaximum");
        factory.make("Message");
        factory.make("StartTurn");
        factory.make("MoveToken");
        factory.make("PassGo");
        factory.make("PropertyOptions");
        factory.make("PartnerOptions");
    }
}

