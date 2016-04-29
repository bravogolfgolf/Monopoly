package game.interactors.versionoptions;

import game.controllers.ControllerRequest;
import game.interactors.Interactor;
import game.presenters.Presenter;

public class VersionOptions extends Interactor {

    private final VersionOptionsPresenter presenter;
    private final VersionOptionsVersionFactory factory;
    private final VersionOptionsResponse response = new VersionOptionsResponse();

    public VersionOptions(Presenter presenter, VersionOptionsVersionFactory factory) {
        this.presenter = presenter;
        this.factory = factory;
    }

    @Override
    public void handle() {
        response.versions = factory.getAvailableVersions();
        presenter.selectVersionPromptMessage();
        presenter.availableVersionsMessage(response);
    }

    @Override
    public void handle(ControllerRequest request) {
        factory.make(request.string);
        response.version = request.string;
        presenter.versionCreatedMessage(response);
    }
}
