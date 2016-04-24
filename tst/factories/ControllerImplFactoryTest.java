package game.factories;

import game.manager.ControllerFactory;
import game.presenters.PresenterEn;
import game.view.View;
import org.junit.Before;
import org.junit.Test;

public class ControllerImplFactoryTest {

    private final ConsoleDummy console = new ConsoleDummy();
    private final View view = new ViewDummy(console);
    private final PresenterEn presenter = new PresenterEnDummy();
    private ControllerFactory controllerFactory;

    @Before
    public void setUp() {

        controllerFactory = new ControllerFactoryImpl(view, presenter);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testControllerFactoryException() {
        controllerFactory.make("");
    }

    @Test
    public void testMakeController() {
        controllerFactory.make("SelectVersion");
        controllerFactory.make("CreatePlayer");
        controllerFactory.make("Options");
        controllerFactory.make("SelectFirst");
    }
}

