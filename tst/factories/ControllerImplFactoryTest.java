package game.factories;

import org.junit.Before;
import org.junit.Test;

public class ControllerImplFactoryTest {

    private ControllerFactoryImpl controllerFactory;

    @Before
    public void setUp() {

        controllerFactory = new ControllerFactoryImpl();
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
