package game.controllers;

import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.createplayer.CreatePlayerResponse;
import game.interactors.setupgame.SetupGamePresenter;
import game.interactors.setupgame.SetupGameResponse;

public class PresenterMock implements Presenter, SetupGamePresenter, CreatePlayerPresenter {

    public boolean verifyGetFormattedMessage = false;

    @Override
    public String getFormattedMessage() {
        verifyGetFormattedMessage = true;
        return "";
    }

    @Override
    public void playerCreatedMessage(CreatePlayerResponse response) {

    }

    @Override
    public void exceededPlayerLimitMessage() {

    }

    @Override
    public void createPlayerPromptMessage() {

    }

    @Override
    public void availableTokensMessage(CreatePlayerResponse response) {

    }

    @Override
    public void setupGamePromptMessage() {

    }

    @Override
    public void versionCreatedMessage(SetupGameResponse response) {

    }

    @Override
    public void availableVersionsMessage(SetupGameResponse response) {

    }
}
