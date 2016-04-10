package factories;

import controllers.Controller;
import main.Monopoly;
import org.junit.Test;

public class ControllerFactoryTest {

    private Controller controller;

    @Test(expected = IllegalArgumentException.class)
    public void testControllerFactoryException() {
        Monopoly.controllerFactory.make("");
    }

    @Test
    public void testCreateControllers() {
        controller = Monopoly.controllerFactory.make("CreateBoardController");
        controller = Monopoly.controllerFactory.make("CreatePlayerController");
    }
}

