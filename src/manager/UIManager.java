package game.manager;

import game.controllers.ControllerImpl;
import game.presenters.PresenterEn;
import game.view.Controller;
import game.view.Manager;
import game.view.ViewImpl;

import java.io.IOException;

public abstract class UIManager implements Manager {

    private UIState uiState;
    protected UIManagerPresenter presenter;
    protected ControllerImpl controller;
    private ViewImpl view;

    public void setUiState(UIState uiState) {
        this.uiState = uiState;
    }

    public void setPresenter(PresenterEn presenter) {
        this.presenter = presenter;
    }

    public void setController(ControllerImpl controller) {
        this.controller = controller;
    }

    public void setView(ViewImpl view) {
        this.view = view;
        this.view.setController(controller);
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
