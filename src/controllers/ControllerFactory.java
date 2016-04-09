package controllers;

public interface ControllerFactory {
    Controller make(String controller);
}
