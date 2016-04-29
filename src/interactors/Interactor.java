package game.interactors;

import game.controllers.ControllerRequest;

public abstract class Interactor {

    public abstract void handle();

    public void handle(ControllerRequest request) {
    }
}
