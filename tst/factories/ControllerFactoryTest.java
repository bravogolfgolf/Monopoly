package game.factories;

import org.junit.Before;
import org.junit.Test;

import static game.Monopoly.factory;

public class ControllerFactoryTest {


    @Before
    public void setUp() {
        factory = new ControllerFactoryImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testControllerFactoryException() {
        factory.make("");
    }

    @Test
    public void testMakeController() {
        factory.make("SetupGameController");
        factory.make("CreatePlayerController");
    }
}

