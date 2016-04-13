package game.presenters;

import game.controllers.Presenter;
import game.interactors.createboard.CreateBoardResponse;
import game.interactors.createplayer.CreatePlayerResponse;

public class PresenterEn extends Presenter {


    @Override
    public void boardCreatedMessage(CreateBoardResponse response) {
        template = "%s version of board created.";
        variables = response.versions;
        addToBuffer(template, variables);
    }

    @Override
    public void availableBoardsMessage(CreateBoardResponse response) {
        template = "Available boards: %s";
        variables = response.versions;
        addToBuffer(template, variables);
    }

    @Override
    public void boardPromptMessage() {
        template = "Select versions of board you would like to use.";
        addToBuffer(template);
    }

    @Override
    public void exceededPlayerLimitMessage() {
        template = "Exceeded eight player limit.";
        addToBuffer(template);
    }

    @Override
    public void playerCreatedMessage(CreatePlayerResponse response) {
        template = "Player created with %s tokens.";
        variables = response.tokens;
        addToBuffer(template, variables);
    }

    @Override
    public void playerPromptMessage() {
        template = "Please select tokens for player.";
        addToBuffer(template);
    }

    @Override
    public void tokenInUseMessage(CreatePlayerResponse response) {
        template = "%s tokens already in use.";
        variables = response.tokens;
        addToBuffer(template, variables);
    }
}
