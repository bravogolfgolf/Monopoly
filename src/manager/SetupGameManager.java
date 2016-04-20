package game.manager;

import static game.Monopoly.addControllerToStack;

public class SetupGameManager extends ManagerImpl {

    public SetupGameManager(State state, ControllerFactory factory) {
        super(state, factory);
    }

    @Override
    public void addCommandBackToList() {
        controller = factory.make("SetupGame");
        addControllerToStack(controller);
    }

    @Override
    public void addNextCommandToList() {
        controller=factory.make("CreatePlayer");
        addControllerToStack(controller);
    }
}
