package game.factories;

import game.display.Console;
import game.entities.Banker;
import game.manager.StateManager;
import game.parser.Parser;
import game.presenters.PresenterEn;
import org.junit.Test;

public class InteractorFactoryTest {

    private final Parser parser = new Parser();
    private final Console console = new Console(parser);
    private final PresenterEn presenter = new PresenterEn(console, parser);
    private final VersionFactory versionFactory = new VersionFactory();
    private final Banker banker = new Banker();
    private final StateManager   manager = new StateManager();
    private final InteractorFactory interactorFactory = new InteractorFactory(presenter, versionFactory, banker, manager);

      @Test(expected = IllegalArgumentException.class)
    public void testInteractorFactoryException() {
        interactorFactory.make("");
    }

    @Test
    public void testMakeInteractorOfType() {
        interactorFactory.make("VersionOptions");
        interactorFactory.make("TokenOptionsFewerThanMinimum");
        interactorFactory.make("TokenOptionsMinimumToMaximum");
        interactorFactory.make("Message");
        interactorFactory.make("RollDice");
        interactorFactory.make("PassGo");
        interactorFactory.make("PropertyOptions");
        interactorFactory.make("PartnerOptions");
    }
}