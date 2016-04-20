package game.manager;

import game.Command;
import game.controllers.Manager;

abstract class ManagerImpl implements Manager {

    private State state;
    Command controller;
    final ControllerFactory factory;

    ManagerImpl(State state, ControllerFactory factory) {
        this.state = state;
        this.factory = factory;
    }

    void setState(State state) {
        this.state = state;
    }

    @Override
    public void validEntry() {
        state.validNumberEntered(this);
    }

    @Override
    public void invalidEntry() {
        state.invalidNumberEntered(this);
    }

    public abstract void addCommandBackToList();

    public abstract void addNextCommandToList();
}
