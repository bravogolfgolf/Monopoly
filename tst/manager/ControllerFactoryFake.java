package game.manager;

import game.Command;
import game.factories.ControllerFactoryImpl;

class ControllerFactoryFake extends ControllerFactoryImpl {

    String verifyMakeString = "";

    @Override
    public Command make(String controller) {
        verifyMakeString = controller;
        return super.make(controller);
    }
}
