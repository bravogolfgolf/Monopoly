package game.factories;

import game.Controller;
import org.junit.Before;
import org.junit.Test;

import static game.Monopoly.controllerFactory;

public class ControllerFactoryTest {

    private Controller controller;

    @Before
    public void setUp() throws Exception {
        controllerFactory = new ControllerFactoryImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testControllerFactoryException() {
        controller = controllerFactory.make("");
    }

    @Test
    public void testMakeController() {
        controller = controllerFactory.make("CreateBoardController");
        controller = controllerFactory.make("CreatePlayerController");
    }
}

