package game.manager;

import game.controllers.Controller;

public interface ControllerFactory {

    Controller make(String controller);
}
