package game.interactors;

import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.setupgame.SetupGamePresenter;

public class PresenterEnMock implements SetupGamePresenter, CreatePlayerPresenter {

    public boolean verifyVersionCreatedMessage = false;
    public boolean verifySetupGamePromptMessage = false;
    public boolean verifyAvailableVersionsMessage = false;
    public boolean verifyExceededPlayerLimitMessage = false;
    public boolean verifyPlayerCreatedMessage = false;
    public boolean verifyCreatePlayerPromptMessage = false;
    public boolean verifyAvailableTokensMessage = false;
    public boolean verifyUserInterfaceOptionsMessage = false;


    @Override
    public void versionCreatedMessage(InteractorResponse response) {
        verifyVersionCreatedMessage = true;
    }

    @Override
    public void setupGamePromptMessage() {
        verifySetupGamePromptMessage = true;
    }

    @Override
    public void availableVersionsMessage(InteractorResponse response) {
        verifyAvailableVersionsMessage = true;
    }

    @Override
    public void userInterfaceOptionsMessage(InteractorResponse response) {
        verifyUserInterfaceOptionsMessage = true;
    }

    @Override
    public void exceededPlayerLimitMessage() {
        verifyExceededPlayerLimitMessage = true;
    }

    @Override
    public void playerCreatedMessage(InteractorResponse response) {
        verifyPlayerCreatedMessage = true;
    }

    @Override
    public void createPlayerPromptMessage() {
        verifyCreatePlayerPromptMessage = true;
    }

    @Override
    public void availableTokensMessage(InteractorResponse response) {
        verifyAvailableTokensMessage = true;
    }
}
