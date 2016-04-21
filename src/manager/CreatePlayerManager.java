package game.manager;

import game.Command;
import game.Monopoly;

public class CreatePlayerManager extends ManagerImpl {

    public CreatePlayerManager(State state, ControllerFactory factory) {
        super(state, factory);
    }

    @Override
    public void addCommandBackToList() {
        Command controller = factory.make("CreatePlayer");
        Monopoly.addControllerToStack(controller);
    }

    @Override
    public void addNextCommandToList() {

    }
}
