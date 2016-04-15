package game.presenters;

import game.controllers.Presenter;
import game.interactors.createplayer.CreatePlayerResponse;
import game.interactors.setupgame.SetupGameResponse;

public class PresenterEn extends Presenter {


    @Override
    public void versionCreatedMessage(SetupGameResponse response) {
        template = "%s version of game created.";
        variables = response.versions;
        addMessageToBuffer(template, variables);
    }

    @Override
    public void availableVersionsMessage(SetupGameResponse response) {
        template = "Available versions: %s";
        variables = response.versions;
        addMenuToBuffer(template, variables);
    }

    @Override
    public void setupGamePromptMessage() {
        template = "Select version of game you would like to play.";
        addMessageToBuffer(template);
    }

    @Override
    public void exceededPlayerLimitMessage() {
        template = "Exceeded eight player limit.";
        addMessageToBuffer(template);
    }

    @Override
    public void playerCreatedMessage(CreatePlayerResponse response) {
        template = "Player created with %s token.";
        variables = response.tokens;
        addMessageToBuffer(template, variables);
    }

    @Override
    public void createPlayerPromptMessage() {
        template = "Please select token for player.";
        addMessageToBuffer(template);
    }

    @Override
    public void tokenInUseMessage(CreatePlayerResponse response) {
        template = "%s token already in use.";
        variables = response.tokens;
        addMessageToBuffer(template, variables);
    }

    @Override
    public void availableTokensMessage(CreatePlayerResponse response) {
        template = "Available tokens: %s";
        variables = response.tokens;
        addMenuToBuffer(template, variables);
    }
}
