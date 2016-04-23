package game.controllers;

import game.manager.ManagerController;

import java.io.IOException;

public abstract class Controller implements ManagerController {
    protected final ControllerView view;
    protected final ControllerInteractor interactor;
    protected final ControllerPresenter presenter;

    public Controller(ControllerView view, ControllerInteractor interactor, ControllerPresenter presenter) {
        this.interactor = interactor;
        this.view = view;
        this.presenter = presenter;
    }

    public abstract void execute() throws IOException;

    @Override
    public abstract void handle(String text) throws IOException;
}
