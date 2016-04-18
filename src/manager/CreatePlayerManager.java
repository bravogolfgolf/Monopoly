package game.manager;

import game.Controller;
import game.Monopoly;

public class CreatePlayerManager extends ManagerImpl {

    public CreatePlayerManager(State state, ControllerFactory factory) {
        super(state, factory);
    }

    @Override
    public void addCommandBackToList() {
        Controller controller = factory.make("CreatePlayer");
        Monopoly.addControllerToStack(controller);
    }

    @Override
    public void addNextCommandToList() {

    }
}
