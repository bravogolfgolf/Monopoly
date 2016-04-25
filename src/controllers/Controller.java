package game.controllers;

import game.interactors.InteractorRequest;
import game.manager.ManagerController;
import game.parser.ControllerConsole;

import java.io.IOException;

abstract class Controller implements ManagerController {

    ControllerInteractor interactor;
    ControllerPresenter presenter;
    ControllerConsole console;
    final InteractorRequest request = new InteractorRequest();

    @Override
    public abstract void handle(String text) throws IOException;
}
