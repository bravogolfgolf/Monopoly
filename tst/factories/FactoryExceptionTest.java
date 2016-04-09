package factories;

import main.Monopoly;
import org.junit.Test;

public class FactoryExceptionTest {

    @Test(expected = IllegalArgumentException.class)
    public void testPresenterFactoryException() {
        Monopoly.presenterFactory.make("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInteractorFactoryException() {
        Monopoly.interactorFactory.make("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testControllerFactoryException() {
        Monopoly.controllerFactory.make("");
    }
}
