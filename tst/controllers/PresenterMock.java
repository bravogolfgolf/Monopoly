package game.controllers;

import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.createplayer.CreatePlayerResponse;
import game.interactors.setupgame.SetupGamePresenter;
import game.interactors.setupgame.SetupGameResponse;

import java.util.Hashtable;
import java.util.Map;

public class PresenterMock implements Presenter, SetupGamePresenter, CreatePlayerPresenter {

    public boolean verifyGetMenuMapCalled = false;

    @Override
    public String getFormattedMessage() {
        return null;
    }

    @Override
    public Map<Integer, String> getMenuMap() {
        verifyGetMenuMapCalled = true;
        return new Hashtable<Integer, String>() {{
            put(1, "Cat");
        }};
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
