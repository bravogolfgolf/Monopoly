package game.manager;

import game.Controller;
import game.factories.ControllerFactoryImpl;

class ControllerFactoryFake extends ControllerFactoryImpl {

    boolean verifyMakeCalled = false;

    @Override
    public Controller make(String controller) {
        verifyMakeCalled = true;
        return super.make(controller);
    }
}
