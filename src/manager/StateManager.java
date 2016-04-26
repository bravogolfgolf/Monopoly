package game.manager;

import game.controllers.Controller;
import game.parser.ParserManager;

import java.io.IOException;

public abstract class StateManager implements ParserManager {

    private State state;
    final ManagerConsole console;
    final ControllerFactory factory;
    Controller controller;

    StateManager(ControllerFactory factory, ManagerConsole console) {
        this.factory = factory;
        this.console = console;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void initialize() throws IOException {
        state.initialize(this);
    }

    @Override
    public void validTextEntry(String result) throws IOException {
        ((ManagerBasic) controller).handle(result);
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

    public abstract void createController(String commandString);

    public abstract void callHandleOnController() throws IOException;

    public abstract void readView() throws IOException;
}
