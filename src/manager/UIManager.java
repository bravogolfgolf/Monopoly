package game.manager;

import game.controllers.ControllerImpl;
import game.factories.ControllerFactoryImpl;
import game.presenters.PresenterEn;
import game.view.Controller;
import game.view.Manager;
import game.view.ViewImpl;

import java.io.IOException;

public abstract class UIManager implements Manager {

    final ViewImpl view;
    protected final PresenterEn presenter;
    final ControllerFactoryImpl factory;

    UIManager(ViewImpl view, PresenterEn presenter, ControllerFactoryImpl factory) {
        this.view = view;
        this.presenter = presenter;
        this.factory = factory;
    }

    public ControllerImpl controller;
    private UIState uiState;

    public void setUiState(UIState uiState) {
        this.uiState = uiState;
    }

    @Override
    public void initialize() throws IOException {
        uiState.initialize(this);
    }

    @Override
    public void validTextEntry(Controller controller, String result) throws IOException {
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

    public abstract void promptMessage(UIStateImpl state);

    public abstract void createController(String commandString);

    public abstract void executeController() throws IOException;

    public abstract void setViewManager();

    public abstract void setViewController();

    public abstract void readView() throws IOException;
}
