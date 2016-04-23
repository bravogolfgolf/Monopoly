package game.controllers;

import game.interactors.InteractorRequest;
import game.manager.ManagerController;

import java.io.IOException;

abstract class Controller implements ManagerController {
    final ControllerView view;
    final ControllerInteractor interactor;
    final ControllerPresenter presenter;
    final InteractorRequest request = new InteractorRequest();

    Controller(ControllerView view, ControllerInteractor interactor, ControllerPresenter presenter) {
        this.interactor = interactor;
        this.view = view;
        this.presenter = presenter;
    }

    @Override
    public abstract void handle(String text) throws IOException;
}
