package game.factories;

import org.junit.Before;
import org.junit.Test;

import static game.manager.UIStateImpl.CREATE_PLAYER_0;
import static game.manager.UIStateImpl.SETUP_GAME;

public class ControllerImplFactoryTest {

    private CommandFactoryImpl controllerFactory;

    @Before
    public void setUp() {

        controllerFactory = new CommandFactoryImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testControllerFactoryException() {
        controllerFactory.make("", SETUP_GAME);
    }

    @Test
    public void testMakeController() {
        controllerFactory.make("SetupGame", SETUP_GAME);
        controllerFactory.make("CreatePlayer", CREATE_PLAYER_0);
    }
}

