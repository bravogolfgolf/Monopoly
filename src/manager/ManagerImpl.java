package game.manager;

import game.Controller;
import game.controllers.Manager;

abstract class ManagerImpl implements Manager {

    private State state;
    Controller controller;
    final ControllerFactory factory;

    ManagerImpl(State state, ControllerFactory factory) {
        this.state = state;
        this.factory = factory;
    }

    void setState(State state) {
        this.state = state;
    }

    @Override
    public void validNumberEntered() {
        state.validNumberEntered(this);
    }

    @Override
    public void invalidNumberEntered() {
        state.invalidNumberEntered(this);
    }

    @Override
    public void invalidTextEntered() {
        state.invalidTextEntered(this);
    }

    public abstract void addCommandBackToList();

    public abstract void addNextCommandToList();
}
