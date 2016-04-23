package game.interactors.selectversion;

import game.controllers.Interactor;
import game.interactors.InteractorRequest;
import game.interactors.InteractorResponse;

public class SelectVersion implements Interactor {

    private final SelectVersionPresenter presenter;
    private final SelectVersionFactory factory;
    private final InteractorResponse response = new InteractorResponse();

    public SelectVersion(SelectVersionPresenter presenter, SelectVersionFactory factory) {
        this.presenter = presenter;
        this.factory = factory;
    }

    @Override
    public void handle(InteractorRequest request) {
        createVersion(request);
    }

    private void createVersion(InteractorRequest request) {
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
