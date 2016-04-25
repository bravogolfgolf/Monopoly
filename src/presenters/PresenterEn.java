package game.presenters;

import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.createplayer.CreatePlayerResponse;
import game.interactors.options.VersionOptionsPresenter;
import game.interactors.options.VersionOptionsResponse;
import game.interactors.selectfirst.SelectFirstPresenter;
import game.interactors.selectfirst.SelectFirstResponse;
import game.interactors.selectversion.SelectVersionPresenter;
import game.interactors.selectversion.SelectVersionResponse;
import game.interactors.tokenoptions.TokenOptionsPresenter;
import game.interactors.tokenoptions.TokenOptionsResponse;
import game.manager.ManagerPresenter;

public class PresenterEn extends Presenter implements ManagerPresenter, SelectVersionPresenter, CreatePlayerPresenter, VersionOptionsPresenter, TokenOptionsPresenter, SelectFirstPresenter {

    @Override
    public void selectVersionPromptMessage() {
        template = "\nSelect version of game you would like to play.";
        addNewLine(template);
    }

    @Override
    public void availableVersionsMessage(VersionOptionsResponse response) {
        template = "Available versions: %s";
        variables = response.versions;
        clearAndCreateMenuMap(variables);
        addMenuToBuffer(template, menuMap);
    }

    @Override
    public void versionCreatedMessage(SelectVersionResponse response) {
        template = "\n%s version of game created.";
        variables = new String[]{response.version};
        addMessageToBuffer(template, variables);
    }

    @Override
    public void createPlayerPromptMessageFewerThanTwo() {
        template = "\nPlease select token for player. (Players 2 - 8)";
        addNewLine(template);
    }

    @Override
    public void createPlayerPromptMessageTwoOrMore() {
        template = "\nPlease select token for player or (0)Play to begin. (Players 2 - 8)";
        addNewLine(template);
    }

    @Override
    public void availableTokensMessage(VersionOptionsResponse response) {
        template = "Available tokens: %s";
        clearAndCreateMenuMap(response.tokens);
        addMenuToBuffer(template, menuMap);
    }

    @Override
    public void playerCreatedMessage(CreatePlayerResponse response) {
        template = "\nPlayer created with %s token.";
        variables = new String[]{response.token};
        addMessageToBuffer(template, variables);
    }

    @Override
    public void playerSelectedToGoFirstMessage(SelectFirstResponse response) {
        template = "\n%s selected to go first.";
        variables = new String[]{response.token};
        addMessageToBuffer(template, variables);
    }

    @Override
    public void startTurn() {
        template = "\nAvailable options: (0)Roll.";
        addNewLine(template);
    }

    @Override
    public void availableTokensMessage(TokenOptionsResponse response) {

    }
}