package game.controllers;

import game.interactors.InteractorRequest;

class InteractorMock implements ControllerInteractor {

    boolean verifyUserInterfaceOptionsCalled = false;
    boolean verifyHandleCalled = false;

    @Override
    public void userInterfaceOptions() {
        verifyUserInterfaceOptionsCalled = true;
    }

    @Override
    public void handle(InteractorRequest request) {
        verifyHandleCalled = true;
    }
}
