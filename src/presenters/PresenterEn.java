package game.presenters;

import game.interactors.InteractorResponse;
import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.options.OptionsPresenter;
import game.interactors.selectversion.SelectVersionPresenter;
import game.manager.ManagerPresenter;

public class PresenterEn extends Presenter implements CreatePlayerPresenter, SelectVersionPresenter, OptionsPresenter, ManagerPresenter {

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
    public void selectVersionPromptMessage() {
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
    public void createPlayerPromptMessageFewerThanTwo() {
        template = "Please select token for player. (Players 2 - 8)";
        addMessageToBuffer(template);
    }

    @Override
    public void createPlayerPromptMessageTwoOrMore() {
        template = "Please select token for player or 0 to begin play. (Players 2 - 8)";
        addMessageToBuffer(template);
    }

    @Override
    public void availableTokensMessage(InteractorResponse response) {
        template = "Available tokens: %s";
        createMenuMap(response.options);
        addMenuToBuffer(template, menuMap);
    }
}