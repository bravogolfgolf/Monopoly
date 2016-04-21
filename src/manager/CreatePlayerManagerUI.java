package game.manager;

import game.Command;
import game.Monopoly;

public class CreatePlayerManagerUI extends ManagerUI {

    public CreatePlayerManagerUI(ManagerUIPresenter presenter, ControllerFactory factory) {
        super(presenter, factory);
    }

    @Override
    public void promptMessage(StateImpl state) {

    }

    @Override
    public void addCommandBackToList() {
    }

    @Override
    public void addNextCommandToList(String command, StateImpl state) {
        Command controller = factory.make(command, state);
        Monopoly.addControllerToStack(controller);

    }
}
