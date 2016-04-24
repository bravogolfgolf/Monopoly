package game.controllers;

import game.interactors.InteractorRequest;
import game.manager.ManagerController;

import java.io.IOException;

abstract class Controller implements ManagerController {

    ControllerInteractor interactor;
    ControllerPresenter presenter;
    InteractorRequest request = new InteractorRequest();

    @Override
    public abstract void handle(String text) throws IOException;
}
