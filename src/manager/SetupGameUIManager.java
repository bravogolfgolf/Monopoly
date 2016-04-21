package game.manager;

import static game.Monopoly.addControllerToStack;

public class SetupGameUIManager extends UIManager {

    public SetupGameUIManager(ManagerUIPresenter presenter, ControllerFactory factory) {
        super(presenter, factory);
    }

    @Override
    public void promptMessage(StateImpl state) {
        presenter.setupGamePromptMessage();
    }

    @Override
    public void addCommandBackToList() {

    }

    @Override
    public void addNextCommandToList(String command, StateImpl state) {
        controller = factory.make(command, state);
        addControllerToStack(controller);
    }
}
