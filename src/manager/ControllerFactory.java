package game.manager;

import game.Command;

public interface ControllerFactory {

    Command make(String controller, StateImpl stateUI);
}
