package factories;

import main.Controller;
import main.Monopoly;
import org.junit.Test;

public class ControllerFactoryTest {


    @Test(expected = IllegalArgumentException.class)
    public void testControllerFactoryException() {
        Monopoly.controllerFactory = new ControllerFactoryImpl();
        Monopoly.controllerFactory.make("");
    }

    @Test
    public void testCreateControllers() {
        Monopoly.controllerFactory = new ControllerFactoryImpl();
        Controller controller = Monopoly.controllerFactory.make("CreateBoardController");
        controller = Monopoly.controllerFactory.make("CreatePlayerController");
    }
}

