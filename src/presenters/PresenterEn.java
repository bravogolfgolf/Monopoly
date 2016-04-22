package game.presenters;

import game.interactors.InteractorResponse;
import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.setupgame.SetupGamePresenter;
import game.manager.UIManagerPresenter;

public class PresenterEn extends PresenterImpl implements UIManagerPresenter, CreatePlayerPresenter, SetupGamePresenter {

    @Override
    public void versionCreatedMessage(InteractorResponse response) {
        template = "%s version of game created.";
        variables = response.options;
        addMessageToBuffer(template, variables);
    }

    @Override
    public void availableVersionsMessage(InteractorResponse response) {
        template = "Available versions: %s";
        variables = response.options;
        createMenuMap(response.options);
        addMenuToBuffer(template, menuMap);
    }

    @Override
    public void setupGamePromptMessage() {
        template = "Select version of game you would like to play.";
        addMessageToBuffer(template);
    }

    @Override
    public void playerCreatedMessage(InteractorResponse response) {
        template = "Player created with %s token.";
        variables = response.options;
        addMessageToBuffer(template, variables);
    }

    @Override
    public void createPlayerPromptMessage() {
        template = "Please select tokens for players. (Players 2 - 8)";
        addMessageToBuffer(template);
    }

    @Override
    public void availableTokensMessage(InteractorResponse response) {
        template = "Available tokens: %s";
        createMenuMap(response.options);
        addMenuToBuffer(template, menuMap);
    }
}