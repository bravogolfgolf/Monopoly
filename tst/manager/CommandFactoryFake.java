package game.manager;

import game.Command;
import game.factories.CommandFactoryImpl;

class CommandFactoryFake extends CommandFactoryImpl {

    String verifyMakeString = "";

    @Override
    public Command make(String controller, UIStateImpl stateUI) {
        verifyMakeString = controller;
        return super.make(controller, stateUI);
    }
}
