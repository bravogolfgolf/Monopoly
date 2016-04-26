package game.manager;

import java.io.IOException;

public class StateManagerImpl extends StateManager {

    public StateManagerImpl(ControllerFactory factory, ManagerConsole console) {
        super(factory, console);
    }

    @Override
    public void createController(String controller) {
        super.controller = factory.make(controller);
    }

    @Override
    public void callHandleOnController() throws IOException {
        controller.execute();
    }

    @Override
    public void readView() throws IOException {
        super.console.read();
    }
}
