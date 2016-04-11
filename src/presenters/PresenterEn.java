package game.presenters;

import game.controllers.Presenter;
import game.interactors.createboard.CreateBoardResponse;
import game.interactors.createplayer.CreatePlayerResponse;

import static game.utilities.StringFormatter.addNewLine;

public class PresenterEn extends Presenter {
    private String viewRequest;

    @Override
    public String getViewRequest() {
        return viewRequest;
    }

    @Override
    public void boardCreatedMessage(CreateBoardResponse response) {
        viewRequest = addNewLine(String.format("%s version of board created.", response.message));
    }

    @Override
    public void boardPromptMessage() {
        viewRequest = addNewLine("Select version of board you would like to use.");
    }

    @Override
    public void exceededPlayerLimitMessage() {
        viewRequest = addNewLine("Exceeded eight player limit.");
    }

    @Override
    public void playerCreatedMessage(CreatePlayerResponse response) {
        viewRequest = addNewLine(String.format("Player created with %s token.", response.message));
    }

    @Override
    public void playerPromptMessage() {
        viewRequest = addNewLine("Please select token for player.");
    }

    @Override
    public void tokenInUseMessage(CreatePlayerResponse response) {
        viewRequest = addNewLine(String.format("%s token already in use.", response.message));
    }
}
