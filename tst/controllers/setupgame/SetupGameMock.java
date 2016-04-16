package game.controllers.setupgame;

import game.interactors.setupgame.SetupGame;
import game.interactors.setupgame.SetupGameFactory;
import game.interactors.setupgame.SetupGamePresenter;
import game.interactors.setupgame.SetupGameRequest;

class SetupGameMock extends SetupGame {

    boolean verifyHandleCalled = false;
    boolean verifyAvailableVersionsMessageCalled = false;
    boolean verifySetupGamePromptCalled = false;

    SetupGameMock(SetupGamePresenter presenter, SetupGameFactory factory) {
        super(presenter, factory);
    }

    @Override
    public void setupGamePrompt() {
        verifySetupGamePromptCalled = true;
    }

    @Override
    public void availableVersionsMessage() {
        verifyAvailableVersionsMessageCalled = true;
        super.availableVersionsMessage();
    }

    @Override
    public void handle(SetupGameRequest request) {
        verifyHandleCalled = true;
    }
}