package game.controllers;

import game.interactors.InteractorRequest;

class CreatePlayerMock implements Interactor {

    boolean verifyHandleCalled = false;
    boolean verifyUserInterfaceOptionsCalled = false;

    @Override
    public void userInterfaceOptions() {
        verifyUserInterfaceOptionsCalled = true;
    }

    @Override
    public void handle(InteractorRequest request) {
        verifyHandleCalled = true;
    }
}
