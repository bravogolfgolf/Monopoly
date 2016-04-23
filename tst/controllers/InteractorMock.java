package game.controllers;

import game.interactors.InteractorRequest;

class InteractorMock implements ControllerInteractor {

    boolean verifyHandleCalled = false;

    @Override
    public void handle(InteractorRequest request) {
        verifyHandleCalled = true;
    }
}
