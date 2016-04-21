package game.manager;

import game.Command;
import game.factories.CommandFactoryImpl;

class CommandFactoryFake extends CommandFactoryImpl {

    String verifyMakeCommand = "";
    UIStateImpl verifyMakeState = null;

    @Override
    public Command make(String controller, UIStateImpl stateUI) {
        verifyMakeCommand = controller;
        verifyMakeState = stateUI;
        return super.make(controller, stateUI);
    }
}
