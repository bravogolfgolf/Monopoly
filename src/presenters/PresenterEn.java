package game.presenters;

import game.interactors.InteractorResponse;
import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.setupgame.SetupGamePresenter;

public class PresenterEn extends PresenterImpl implements CreatePlayerPresenter, SetupGamePresenter {

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
    public void exceededPlayerLimitMessage() {
        template = "Exceeded eight player limit.";
        addMessageToBuffer(template);
    }

    @Override
    public void playerCreatedMessage(InteractorResponse response) {
        template = "Player created with %s token.";
        variables = response.options;
        addMessageToBuffer(template, variables);
    }

    @Override
    public void availableTokensMessage(InteractorResponse response) {
        template = "Available tokens: %s";
        createMenuMap(response.options);
        addMenuToBuffer(template, menuMap);
    }
}