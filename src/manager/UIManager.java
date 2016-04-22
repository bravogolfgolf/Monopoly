package game.manager;

import game.view.Manager;

public abstract class UIManager implements Manager {

    private UIState uiState;
    final UIManagerPresenter presenter;

    UIManager(UIManagerPresenter presenter) {
        this.presenter = presenter;
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

    @Override
    public void zeroEntered() {

    }

    public abstract void promptMessage(UIStateImpl state);

    public abstract void addControllerToStack(String commandString);

}
