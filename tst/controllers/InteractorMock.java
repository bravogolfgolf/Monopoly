package game.controllers;

import game.controllers.basic.BasicInteractor;
import game.controllers.basic.BasicRequest;
import game.controllers.setmap.MenuInteractor;

class InteractorMock implements BasicInteractor, MenuInteractor {

    boolean verifyHandleCalled = false;

    @Override
    public void handle(BasicRequest request) {
        verifyHandleCalled = true;
    }

    @Override
    public void handle() {

    }
}
