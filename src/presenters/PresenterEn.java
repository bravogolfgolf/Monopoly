package game.presenters;

import game.controllers.Presenter;
import game.interactors.createplayer.CreatePlayerResponse;
import game.interactors.setupgame.SetupGameResponse;

public class PresenterEn extends Presenter {


    @Override
    public void versionCreatedMessage(SetupGameResponse response) {
        template = "%s version of game created.";
        variables = response.versions;
        addToBuffer(template, variables);
    }

    @Override
    public void availableVersionsMessage(SetupGameResponse response) {
        template = "Available versions: %s";
        variables = response.versions;
        addToBuffer(template, variables);
    }

    @Override
    public void setupGamePromptMessage() {
        template = "Select version of game you would like to play.";
        addToBuffer(template);
    }

    @Override
    public void exceededPlayerLimitMessage() {
        template = "Exceeded eight player limit.";
        addToBuffer(template);
    }

    @Override
    public void playerCreatedMessage(CreatePlayerResponse response) {
        template = "Player created with %s token.";
        variables = response.tokens;
        addToBuffer(template, variables);
    }

    @Override
    public void playerPromptMessage() {
        template = "Please select token for player.";
        addToBuffer(template);
    }

    @Override
    public void tokenInUseMessage(CreatePlayerResponse response) {
        template = "%s token already in use.";
        variables = response.tokens;
        addToBuffer(template, variables);
    }
}
