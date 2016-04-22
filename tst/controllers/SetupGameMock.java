package game.controllers;

import game.interactors.InteractorRequest;

class SetupGameMock implements Interactor {

    boolean verifyUserInterfaceOptionsCalled = false;

    @Override
    public void userInterfaceOptions() {
        verifyUserInterfaceOptionsCalled = true;
    }

    @Override
    public void handle(InteractorRequest request) {
    }
}