package game.doubles;

import game.controllers.Controller;
import game.entities.Dice;
import game.manager.ControllerFactory;

public class ControllerFactoryImplDummy implements ControllerFactory {
    @Override
    public Controller make(String controller) {
        return null;
    }

    @Override
    public Controller make(String controller, Dice dice) {
        return null;
    }
}
