package game.manager;

import game.factories.ControllerFactory;

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
}
