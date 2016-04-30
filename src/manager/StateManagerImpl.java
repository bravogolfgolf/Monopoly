package game.manager;

import game.entities.Dice;

import java.io.IOException;

public class StateManagerImpl extends StateManager {

    public StateManagerImpl(ControllerFactory factory) {
        super(factory);
    }

    @Override
    public void createAndExecuteController(String contollerString) throws IOException {
        super.controller = factory.make(contollerString);
        super.controller.execute();
    }

    @Override
    public void createAndExecuteController(String contollerString, Dice dice) {

    }
}
