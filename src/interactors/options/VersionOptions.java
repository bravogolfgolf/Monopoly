package game.interactors.options;

import game.controllers.menu.MenuInteractor;

public class VersionOptions implements MenuInteractor {

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
        presenter.availableVersionsMessage(response);
    }
}
