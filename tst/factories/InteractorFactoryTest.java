package game.factories;

import game.display.Console;
import game.parser.Parser;
import game.presenters.PresenterEn;
import org.junit.Test;

public class InteractorFactoryTest {

    private final Parser parser = new Parser();
    private final Console console = new Console(parser);
    private final PresenterEn presenter = new PresenterEn(console, parser);
    private final VersionFactory factory = new VersionFactory();

    private final ControllerFactoryInteractorFactory interactorFactory = new InteractorFactory(presenter, factory);

    @Test(expected = IllegalArgumentException.class)
    public void testInteractorFactoryException() {
        interactorFactory.make("");
    }

    @Test
    public void testMakeInteractorOfType() {
        interactorFactory.make("VersionOptions");
    }
}