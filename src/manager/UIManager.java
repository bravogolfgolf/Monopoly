package game.manager;

import game.view.Manager;

import java.io.IOException;

public abstract class UIManager implements Manager {

    private UIState uiState;
    final ManagerView view;
    final ManagerPresenter presenter;
    final ControllerFactory factory;
    Controller controller;

    UIManager(ManagerView view, ManagerPresenter presenter, ControllerFactory factory) {
        this.view = view;
        this.presenter = presenter;
        this.factory = factory;
    }

    public void setUiState(UIState uiState) {
        this.uiState = uiState;
    }

    public void initialize() throws IOException {
        uiState.initialize(this);
    }

    @Override
    public void validTextEntry(String result) throws IOException {
        controller.handle(result);
        uiState.validTextEntry(this);
    }

    @Override
    public void invalidEntry() throws IOException {
        initialize();
    }

    @Override
    public void validNumber() throws IOException {
        uiState.validNumber(this);
    }

    public abstract void promptMessage(String state);

    public abstract void createController(String commandString);

    public abstract void executeController() throws IOException;

    public abstract void setViewManager();

    public abstract void readView() throws IOException;
}
