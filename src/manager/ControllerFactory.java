package game.manager;

import game.controllers.Writer;

public interface ControllerFactory {

    Writer make(String controller);
}
