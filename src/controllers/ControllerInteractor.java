package game.controllers;

import game.interactors.InteractorRequest;

public interface ControllerInteractor {

    void handle(InteractorRequest request);

}
