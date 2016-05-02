package game.manager;

import game.controllers.Controller;

public interface ManagerControllerFactory {

    Controller make(String controller);
}
