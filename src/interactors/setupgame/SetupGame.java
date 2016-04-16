package game.interactors.setupgame;

import game.controllers.setupgame.SetupGameInteractor;

public class SetupGame implements SetupGameInteractor {

    private final SetupGamePresenter presenter;
    private final SetupGameFactory factory;
    private final SetupGameResponse response = new SetupGameResponse();
    private SetupGameRequest request;

    public SetupGame(SetupGamePresenter presenter, SetupGameFactory factory) {
        this.presenter = presenter;
        this.factory = factory;
    }

    @Override
    public void handle(SetupGameRequest request) {
        this.request = request;
        if (requestedVersionIsAvailable()) versionCreatedMessage();
        else setupGamePrompt();
    }

    private boolean requestedVersionIsAvailable() {
        return factory.isAvailable(request.version);
    }

    private void versionCreatedMessage() {
        factory.make(request.version);
        response.versions = new String[]{request.version};
        presenter.versionCreatedMessage(response);
    }

    @Override
    public void setupGamePrompt() {
        presenter.setupGamePromptMessage();
        availableVersionsMessage();
    }

    @Override
    public void availableVersionsMessage() {
        response.versions = factory.getAvailableVersions();
        presenter.availableVersionsMessage(response);
    }
}
