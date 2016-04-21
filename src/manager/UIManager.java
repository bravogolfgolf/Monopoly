package game.manager;

import game.view.Manager;

public abstract class UIManager implements Manager {

    private UIState uiState;
    final ManagerUIPresenter presenter;
    final ControllerFactory factory;

    UIManager(ManagerUIPresenter presenter, ControllerFactory factory) {
        this.presenter = presenter;
        this.factory = factory;
    }

    public void setUiState(UIState uiState) {
        this.uiState = uiState;
    }

    @Override
    public void promptMessage() {
        uiState.promptMessage(this);
    }

    @Override
    public void validUseCaseEntry() {
        uiState.validUseCaseEntry(this);
    }

    @Override
    public void invalidEntry() {
        uiState.invalidEntry(this);
    }

    public abstract void promptMessage(UIStateImpl state);

    public abstract void addCommandToStack(String commandString, UIStateImpl state);

}
