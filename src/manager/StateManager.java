package game.manager;

import game.view.ViewManager;

import java.io.IOException;

public abstract class StateManager implements ViewManager {

    private State state;
    final ManagerView view;
    final ManagerPresenter presenter;
    final ControllerFactory factory;
    ManagerController controller;

    StateManager(ManagerView view, ManagerPresenter presenter, ControllerFactory factory) {
        this.view = view;
        this.presenter = presenter;
        this.factory = factory;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void initialize() throws IOException {
        state.initialize(this);
    }

    @Override
    public void validTextEntry(String result) throws IOException {
        controller.handle(result);
        state.validTextEntry(this);
    }

    @Override
    public void invalidEntry() throws IOException {
        initialize();
    }

    @Override
    public void validNumber() throws IOException {
        state.validNumber(this);
    }

    public abstract void promptMessage(String state);

    public abstract void createController(String commandString);

    public abstract void callHandleOnController(String versions) throws IOException;

    public abstract void setViewManager();

    public abstract void readView() throws IOException;
}
