package game.manager;

import game.Controller;

public interface ControllerFactory {

    Controller make(String controller);
}
