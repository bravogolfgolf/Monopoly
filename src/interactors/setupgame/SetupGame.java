package game.interactors.setupgame;

import game.controllers.Interactor;
import game.interactors.InteractorRequest;

public class SetupGame implements Interactor {

    private final SetupGamePresenter presenter;
    private final SetupGameFactory factory;
    private final SetupGameResponse response = new SetupGameResponse();
    private InteractorRequest request;

    public SetupGame(SetupGamePresenter presenter, SetupGameFactory factory) {
        this.presenter = presenter;
        this.factory = factory;
    }

    @Override
    public void handle(InteractorRequest request) {
        this.request = request;
        versionCreatedMessage();
    }

    private void versionCreatedMessage() {
        factory.make(request.string);
        response.versions = new String[]{request.string};
        presenter.versionCreatedMessage(response);
    }

    @Override
    public void userInterfacePrompt() {
        presenter.setupGamePromptMessage();
        userInterfaceOptions();
    }

    @Override
    public void userInterfaceOptions() {
        response.versions = factory.getAvailableVersions();
        presenter.availableVersionsMessage(response);
    }
}
