package factories;

import main.monopoly;
import org.junit.Test;

public class FactoryExceptionTest {

    @Test(expected = IllegalArgumentException.class)
    public void testPresenterFactoryException() {
        monopoly.presenterFactory.make("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInteractorFactoryException() {
        monopoly.interactorFactory.make("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testControllerFactoryException() {
        monopoly.controllerFactory.make("");
    }
}
