package game.controllers.setupgame;

import game.controllers.Presenter;
import game.interactors.setupgame.SetupGame;
import game.interactors.setupgame.SetupGameFactory;
import game.interactors.setupgame.SetupGameRequest;

class SetupGameMock extends SetupGame {

    boolean verifyHandleCalled = false;
    boolean verifyAvailableVersionsMessageCalled = false;
    boolean verifySetupGamePromptCalled = false;

    SetupGameMock(Presenter presenter, SetupGameFactory factory) {
        super(presenter, factory);
    }

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