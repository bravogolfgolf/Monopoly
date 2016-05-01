package game.manager;

import game.controllers.Controller;
import game.entities.Dice;

public interface ManagerControllerFactory {

    Controller make(String controller);

    Controller make(String controller, Dice dice);
}
