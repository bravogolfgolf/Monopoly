package game.preseters;

import game.interactors.setupgame.*;

class SetupGameStub extends SetupGame {

    private final SetupGamePresenter presenter;
    private final SetupGameResponse response = new SetupGameResponse();

    SetupGameStub(SetupGamePresenter presenter, SetupGameFactory factory) {
        super(presenter, factory);
        this.presenter = presenter;
    }

    @Override
    public void handle(SetupGameRequest request) {
    }

    @Override
    protected void versionCreatedMessage() {
        response.versions = new String[]{"USA"};
        presenter.versionCreatedMessage(response);
    }

    @Override
    public void setupGamePrompt() {
        presenter.setupGamePromptMessage();
    }

    @Override
    public void availableVersionsMessage() {
        response.versions = new String[]{"USA", "FRA"};
        presenter.availableVersionsMessage(response);
    }
}