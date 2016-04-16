package game.controllers.setupgame;

import game.interactors.setupgame.SetupGameRequest;

class SetupGameMock implements SetupGameInteractor {

    boolean verifyHandleCalled = false;
    boolean verifyAvailableVersionsMessageCalled = false;
    boolean verifySetupGamePromptCalled = false;

    @Override
    public void setupGamePrompt() {
        verifySetupGamePromptCalled = true;
    }

    @Override
    public void availableVersionsMessage() {
        verifyAvailableVersionsMessageCalled = true;
    }

    @Override
    public void handle(SetupGameRequest request) {
        verifyHandleCalled = true;
    }
}