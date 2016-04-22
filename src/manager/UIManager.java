package game.manager;

import game.view.Controller;
import game.view.Manager;

import java.io.IOException;

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
    public void initialize() {
        uiState.initialize(this);
    }

    @Override
    public void validTextEntry(Controller controller, String result) throws IOException {
        controller.handle(result);
        uiState.validTextEntry(this);
    }

    @Override
    public void invalidEntry() {
        uiState.invalidEntry(this);
    }

    @Override
    public void validNumber() {
        uiState.validNumber(this);
    }

    public abstract void promptMessage(UIStateImpl state);

    public abstract void addControllerToStack(String commandString);

}
