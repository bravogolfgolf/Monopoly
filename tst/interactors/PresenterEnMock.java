package game.interactors;

import game.interactors.createplayer.CreatePlayerResponse;
import game.interactors.setupgame.SetupGameResponse;
import game.presenters.PresenterEn;

public class PresenterEnMock extends PresenterEn {

    public boolean verifyVersionCreatedMessage = false;
    public boolean verifySetupGamePromptMessage = false;
    public boolean verifyTokenInUseMessage = false;
    public boolean verifyExceededPlayerLimitMessage = false;
    public boolean verifyCreatePlayerPromptMessage = false;
    public boolean verifyAvailableVersionsMessage = false;
    public boolean verifyPlayerCreatedMessage = false;
    public boolean verifyAvailableTokensMessage = false;

    @Override
    public void versionCreatedMessage(SetupGameResponse response) {
        verifyVersionCreatedMessage = true;
    }

    @Override
    public void setupGamePromptMessage() {
        verifySetupGamePromptMessage = true;
    }

    @Override
    public void availableVersionsMessage(SetupGameResponse response) {
        verifyAvailableVersionsMessage = true;
    }

    @Override
    public void exceededPlayerLimitMessage() {
        verifyExceededPlayerLimitMessage = true;
    }

    @Override
    public void playerCreatedMessage(CreatePlayerResponse response) {
        verifyPlayerCreatedMessage = true;
    }

    @Override
    public void tokenInUseMessage(CreatePlayerResponse response) {
        verifyTokenInUseMessage = true;
    }

    @Override
    public void createPlayerPromptMessage() {
        verifyCreatePlayerPromptMessage = true;
    }

    @Override
    public void availableTokensMessage(CreatePlayerResponse response) {
        verifyAvailableTokensMessage = true;
    }
}
