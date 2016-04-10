package factories;

import controllers.Controller;
import main.Context;
import org.junit.Test;

public class ControllerFactoryTest {


    @Test(expected = IllegalArgumentException.class)
    public void testControllerFactoryException() {
        Context.controllerFactory = new ControllerFactoryImpl();
        Context.controllerFactory.make("");
    }

    @Test
    public void testCreateControllers() {
        Context.controllerFactory = new ControllerFactoryImpl();
        Controller controller = Context.controllerFactory.make("CreateBoardController");
        controller = Context.controllerFactory.make("CreatePlayerController");
    }
}

