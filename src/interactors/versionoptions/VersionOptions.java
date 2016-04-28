package game.interactors.versionoptions;

import game.controllers.writer.ReaderRequest;
import game.controllers.writer.WriterInteractor;

public class VersionOptions implements WriterInteractor {

    private final VersionOptionsPresenter presenter;
    private final VersionOptionsVersionFactory factory;
    private final VersionOptionsResponse response = new VersionOptionsResponse();

    public VersionOptions(VersionOptionsPresenter presenter, VersionOptionsVersionFactory factory) {
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
    public void handle(ReaderRequest request) {
        factory.make(request.string);
        response.version = request.string;
        presenter.versionCreatedMessage(response);
    }
}
