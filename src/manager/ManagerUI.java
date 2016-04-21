package game.manager;

import game.Command;
import game.view.Manager;

public abstract class ManagerUI implements Manager {

    private StateUI stateUI;
    final ManagerUIPresenter presenter;
    final ControllerFactory factory;
    Command controller;

    ManagerUI(ManagerUIPresenter presenter, ControllerFactory factory) {
        this.presenter = presenter;
        this.factory = factory;
    }

    public void setStateUI(StateUI stateUI) {
        this.stateUI = stateUI;
    }

    @Override
    public void promptMessage() {
        stateUI.promptMessage(this);
    }

    @Override
    public void validUseCaseEntry() {
        stateUI.validUseCaseEntry(this);
    }

    @Override
    public void invalidEntry() {
        stateUI.invalidEntry(this);
    }

    public abstract void promptMessage(StateImpl state);

    public abstract void addCommandBackToList();

    public abstract void addNextCommandToList(String command, StateImpl state);

}
