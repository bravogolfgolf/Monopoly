package game.controllers;

import game.interactors.Interactor;

class InteractorMock extends Interactor {

    boolean verifyHandleWithArgumentCalled = false;
    boolean verifyHandleWithOutArgumentCalled = false;

    @Override
    public void handle(ControllerRequest request) {
        verifyHandleWithArgumentCalled = true;
    }

    @Override
    public void handle() {
        verifyHandleWithOutArgumentCalled = true;
    }
}
