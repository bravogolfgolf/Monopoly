package game.manager;

import game.controllers.ControllerImpl;
import game.display.ConsoleImpl;
import game.factories.ControllerFactoryImpl;
import game.presenters.PresenterEn;
import game.view.Controller;
import game.view.Manager;
import game.view.ViewImpl;

import java.io.*;

public abstract class UIManager implements Manager {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final ConsoleImpl console = new ConsoleImpl(reader, writer);
    public static final PresenterEn presenter = new PresenterEn();
    public final ViewImpl view = new ViewImpl(console, this);
    public final ControllerFactoryImpl factory = new ControllerFactoryImpl(view, presenter);
    public static ControllerImpl controller;
    private UIState uiState;

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
