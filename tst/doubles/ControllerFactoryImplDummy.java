package game.doubles;

import game.controllers.Controller;
import game.manager.ControllerFactory;

public class ControllerFactoryImplDummy implements ControllerFactory {
    @Override
    public Controller make(String controller) {
        return null;
    }
}
