package game.manager;

import game.controllers.Controller;
import game.entities.Dice;

public interface ControllerFactory {

    Controller make(String controller);

    Controller make(String controller, Dice dice);
}
