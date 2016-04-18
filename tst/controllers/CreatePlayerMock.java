package game.controllers;

import game.interactors.InteractorRequest;

class CreatePlayerMock implements Interactor {

    boolean verifyHandleCalled = false;
    boolean verifyAvailableTokensMessage = false;

    @Override
    public void userInterfacePrompt() {
    }

    @Override
    public void userInterfaceOptions() {
        verifyAvailableTokensMessage = true;
    }

    @Override
    public void handle(InteractorRequest request) {
        verifyHandleCalled = true;
    }
}
