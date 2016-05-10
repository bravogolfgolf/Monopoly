package game.factories;

import game.display.Console;
import game.parser.Parser;
import game.presenters.PresenterEn;
import org.junit.Test;

public class InteractorFactoryTest {

    private final Parser parser = new Parser();
    private final Console console = new Console(parser);
    private final PresenterEn presenter = new PresenterEn(console, parser);
    private final VersionFactory versionFactory = new VersionFactory();

    private final ControllerFactoryInteractorFactory factory = new InteractorFactory(presenter, versionFactory);

    @Test(expected = IllegalArgumentException.class)
    public void testInteractorFactoryException() {
        factory.make("");
    }

    @Test
    public void testMakeInteractorOfType() {
        factory.make("VersionOptions");
    }
}