package game.interactors.selectversion;

import game.controllers.reader.ReaderInteractor;
import game.controllers.reader.ReaderRequest;

public class SelectVersion implements ReaderInteractor {

    private final SelectVersionPresenter presenter;
    private final SelectVersionFactory factory;
    private final SelectVersionResponse response = new SelectVersionResponse();

    public SelectVersion(SelectVersionPresenter presenter, SelectVersionFactory factory) {
        this.presenter = presenter;
        this.factory = factory;
    }

    @Override
    public void handle(ReaderRequest request) {
        factory.make(request.string);
        response.version = request.string;
        presenter.versionCreatedMessage(response);
    }

}
