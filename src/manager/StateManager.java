package game.manager;

import game.controllers.Controller;
import game.controllers.Options;
import game.parser.ParserManager;

import java.io.IOException;

public abstract class StateManager implements ParserManager {

    private State state;
    final ManagerControllerFactory factory;
    Controller controller;

    StateManager(ManagerControllerFactory factory) {
        this.factory = factory;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void initialize() throws IOException {
        state.initialize(this);
    }

    @Override
    public void invalidEntry() throws IOException {
        initialize();
    }

    @Override
    public void validTextEntry(String result) throws IOException {
        ((Options) controller).handle(result);
        state.validTextEntry(this);
    }

    @Override
    public void zeroEntered() throws IOException {
        state.zeroEntered(this);
    }

    @Override
    public void oneEntered() throws IOException {
        state.oneEntered(this);
    }

    @Override
    public void twoEntered() throws IOException {
        state.twoEntered(this);

    }

    public abstract void createAndExecuteController(String contollerString) throws IOException;
}
