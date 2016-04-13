package game.factories;

import org.junit.Before;
import org.junit.Test;

import static game.Monopoly.controllerFactory;

public class ControllerFactoryTest {


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
        controllerFactory.make("SetupGameController");
        controllerFactory.make("CreatePlayerController");
    }
}

