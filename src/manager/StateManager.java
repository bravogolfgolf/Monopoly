package game.manager;

import game.parser.ParserManager;

import java.io.IOException;

public abstract class StateManager implements ParserManager {

    private State state;
    final ManagerPresenter presenter;
    final ManagerConsole console;
    final ControllerFactory factory;
    ManagerController controller;

    StateManager(ManagerPresenter presenter, ControllerFactory factory, ManagerConsole console) {
        this.presenter = presenter;
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

    public abstract void readView() throws IOException;
}
