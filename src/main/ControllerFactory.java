package main;

import controllers.Controller;

public interface ControllerFactory {
    Controller make(String controller);
}
