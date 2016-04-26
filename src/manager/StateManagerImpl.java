package game.manager;

import java.io.IOException;

public class StateManagerImpl extends StateManager {

    public StateManagerImpl(ControllerFactory factory) {
        super(factory);
    }

    @Override
    public void createAndExecuteController(String controller) throws IOException {
        super.controller = factory.make(controller);
        super.controller.execute();
    }
}
