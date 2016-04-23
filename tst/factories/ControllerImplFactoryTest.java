package game.factories;

import game.controllers.ControllerView;
import game.manager.ControllerFactory;
import game.presenters.PresenterEn;
import org.junit.Before;
import org.junit.Test;

public class ControllerImplFactoryTest {

    private final ControllerView view = new ViewDummy();
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
    }
}

