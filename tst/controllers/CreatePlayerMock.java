package game.controllers;

import game.interactors.InteractorRequest;

class CreatePlayerMock implements Interactor {

    boolean verifyHandleCalled = false;
    boolean verifyAvailableTokensMessage = false;
    boolean verifyCreatePlayerPrompt;

    @Override
    public void userInterfacePrompt() {
        verifyCreatePlayerPrompt = true;
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
