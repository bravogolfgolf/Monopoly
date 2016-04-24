package game.presenters;

import game.interactors.InteractorResponse;
import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.options.OptionsPresenter;
import game.interactors.selectfirst.SelectFirstPresenter;
import game.interactors.selectversion.SelectVersionPresenter;
import game.manager.ManagerPresenter;

public class PresenterEn extends Presenter implements ManagerPresenter, SelectVersionPresenter, CreatePlayerPresenter, OptionsPresenter, SelectFirstPresenter {

    @Override
    public void selectVersionPromptMessage() {
        template = "\nSelect version of game you would like to play.";
        addMessageToBuffer(template);
    }

    @Override
    public void availableVersionsMessage(InteractorResponse response) {
        template = "Available versions: %s";
        variables = response.versions;
        createMenuMap(variables);
        addMenuToBuffer(template, menuMap);
    }

    @Override
    public void versionCreatedMessage(InteractorResponse response) {
        template = "\n%s version of game created.";
        variables = new String[]{response.version};
        addMessageToBuffer(template, variables);
    }

    @Override
    public void createPlayerPromptMessageFewerThanTwo() {
        template = "\nPlease select token for player. (Players 2 - 8)";
        addMessageToBuffer(template);
    }

    @Override
    public void createPlayerPromptMessageTwoOrMore() {
        template = "\nPlease select token for player or 0 to begin play. (Players 2 - 8)";
        addMessageToBuffer(template);
    }

    @Override
    public void availableTokensMessage(InteractorResponse response) {
        template = "Available tokens: %s";
        createMenuMap(response.tokens);
        addMenuToBuffer(template, menuMap);
    }

    @Override
    public void playerCreatedMessage(InteractorResponse response) {
        template = "\nPlayer created with %s token.";
        variables = new String[]{response.token.getDescription()};
        addMessageToBuffer(template, variables);
    }

    @Override
    public void playerSelectedToGoFirstMessage(InteractorResponse response) {
        template = "\n%s selected to go first.";
        variables = new String[]{response.token.getDescription()};
        addMessageToBuffer(template, variables);
    }
}