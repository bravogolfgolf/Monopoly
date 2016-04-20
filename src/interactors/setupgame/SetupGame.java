package game.interactors.setupgame;

import game.controllers.Interactor;
import game.interactors.InteractorRequest;
import game.interactors.InteractorResponse;

public class SetupGame implements Interactor {

    private final SetupGamePresenter presenter;
    private final SetupGameFactory factory;
    private final InteractorResponse response = new InteractorResponse();
    private InteractorRequest request;

    public SetupGame(SetupGamePresenter presenter, SetupGameFactory factory) {
        this.presenter = presenter;
        this.factory = factory;
    }

    @Override
    public void handle(InteractorRequest request) {
        this.request = request;
        createVersion();
    }

    private void createVersion() {
        factory.make(request.string);
        response.options = new String[]{request.string};
        presenter.versionCreatedMessage(response);
    }

    @Override
    public void userInterfaceOptions() {
        response.options = factory.getAvailableVersions();
        presenter.availableVersionsMessage(response);
    }
}
