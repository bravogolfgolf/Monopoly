package game.interactors;

import game.interactors.createplayer.CreatePlayerResponse;
import game.interactors.setupgame.SetupGameResponse;
import game.presenters.PresenterEn;

public class PresenterEnMock extends PresenterEn {

    public boolean verifyPlayerCreatedMessage = false;
    public boolean verifyBoardCreateMessage = false;
    public boolean verifyBoardPromptMessage = false;
    public boolean verifyTokenInUseMessage = false;
    public boolean verifyExceededPlayerLimitMessage = false;
    public boolean verifyPlayerPromptMessage = false;
    public boolean verifyAvailableBoardsMessage = false;

    @Override
    public void playerPromptMessage() {
        verifyPlayerPromptMessage = true;
    }

    @Override
    public void versionCreatedMessage(SetupGameResponse response) {
        verifyBoardCreateMessage = true;
    }

    @Override
    public void availableVersionsMessage(SetupGameResponse response) {
        verifyAvailableBoardsMessage = true;
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
    public void exceededPlayerLimitMessage() {
        verifyExceededPlayerLimitMessage = true;
    }

    @Override
    public void setupGamePromptMessage() {
        verifyBoardPromptMessage = true;
    }
}
