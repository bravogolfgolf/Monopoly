package game.interactors;

import game.interactors.createboard.CreateBoardResponse;
import game.interactors.createplayer.CreatePlayerResponse;
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
    public void boardCreatedMessage(CreateBoardResponse response) {
        verifyBoardCreateMessage = true;
    }

    @Override
    public void availableBoardsMessage(CreateBoardResponse response) {
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
    public String getMessage() {
        return null;
    }

    @Override
    public void boardPromptMessage() {
        verifyBoardPromptMessage = true;
    }
}
