package game.controllers;

public interface ControllerInteractor {

    void handle();

    void handle(ControllerRequest request);
}
