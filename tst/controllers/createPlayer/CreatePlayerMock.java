package game.controllers.createPlayer;

import game.interactors.createplayer.CreatePlayer;
import game.interactors.createplayer.CreatePlayerGateway;
import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.createplayer.CreatePlayerRequest;

class CreatePlayerMock extends CreatePlayer {

    boolean verifyHandleCalled = false;
    boolean verifyAvailableTokensMessage = false;
    boolean verifyCreatePlayerPrompt;

    CreatePlayerMock(CreatePlayerPresenter presenter, CreatePlayerGateway repository) {
        super(presenter, repository);
    }

    @Override
    public void createPlayerPrompt() {
        verifyCreatePlayerPrompt = true;
        super.createPlayerPrompt();
    }

    @Override
    public void availableTokensMessage() {
        verifyAvailableTokensMessage = true;
        super.availableTokensMessage();
    }

    @Override
    public void handle(CreatePlayerRequest request) {
        verifyHandleCalled = true;
    }
}
