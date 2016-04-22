package game.factories;

import game.controllers.View;
import game.presenters.PresenterEn;
import org.junit.Before;
import org.junit.Test;

public class ControllerImplFactoryTest {

    private final View view = new ViewDummy();
    private final PresenterEn presenter = new PresenterEnDummy();
    private ControllerFactoryImpl controllerFactory;

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
        controllerFactory.make("SetupGame");
        controllerFactory.make("CreatePlayer");
    }
}

