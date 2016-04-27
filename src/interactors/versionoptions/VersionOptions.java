package game.interactors.versionoptions;

import game.controllers.WriterInteractor;

public class VersionOptions implements WriterInteractor {

    private final VersionOptionsPresenter presenter;
    private final VersionOptionsFactory factory;
    private final VersionOptionsResponse response = new VersionOptionsResponse();

    public VersionOptions(VersionOptionsPresenter presenter, VersionOptionsFactory factory) {
        this.presenter = presenter;
        this.factory = factory;
    }

    @Override
    public void handle() {
        response.versions = factory.getAvailableVersions();
        presenter.selectVersionPromptMessage();
        presenter.availableVersionsMessage(response);
    }
}
