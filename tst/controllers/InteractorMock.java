package game.controllers;

import game.controllers.basic.BasicInteractor;
import game.controllers.basic.BasicRequest;
import game.controllers.setmap.MenuInteractor;

class InteractorMock implements BasicInteractor, MenuInteractor {

    boolean verifyHandleWithArgumentCalled = false;
    boolean verifyHandleWithOutArgumentCalled = false;

    @Override
    public void handle(BasicRequest request) {
        verifyHandleWithArgumentCalled = true;
    }

    @Override
    public void handle() {
        verifyHandleWithOutArgumentCalled = true;
    }
}
