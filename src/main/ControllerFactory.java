package main;

public interface ControllerFactory {
    Controller make(String controller);
}
