package game.controllers;

import game.interactors.InteractorRequest;

class SetupGameMock implements Interactor {

    boolean verifyHandleCalled = false;
    boolean verifyUserInterfaceOptionsCalled = false;
    boolean verifyUserInterfacePromptCalled = false;

    @Override
    public void userInterfacePrompt() {
        verifyUserInterfacePromptCalled = true;
    }

    @Override
    public void userInterfaceOptions() {
        verifyUserInterfaceOptionsCalled = true;
    }

    @Override
    public void handle(InteractorRequest request) {
        verifyHandleCalled = true;
    }
}