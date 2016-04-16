package game.controllers.createPlayer;

import game.interactors.createplayer.CreatePlayerRequest;

class CreatePlayerMock implements CreatePlayerInteractor {

    boolean verifyHandleCalled = false;
    boolean verifyAvailableTokensMessage = false;
    boolean verifyCreatePlayerPrompt;

    @Override
    public void createPlayerPrompt() {
        verifyCreatePlayerPrompt = true;
    }

    @Override
    public void availableTokensMessage() {
        verifyAvailableTokensMessage = true;
    }

    @Override
    public void handle(CreatePlayerRequest request) {
        verifyHandleCalled = true;
    }
}
