package game.interactors.selectversion;

import game.controllers.basic.BasicInteractor;
import game.controllers.basic.BasicRequest;

public class SelectVersion implements BasicInteractor {

    private final SelectVersionPresenter presenter;
    private final SelectVersionFactory factory;
    private final SelectVersionResponse response = new SelectVersionResponse();

    public SelectVersion(SelectVersionPresenter presenter, SelectVersionFactory factory) {
        this.presenter = presenter;
        this.factory = factory;
    }

    @Override
    public void handle(BasicRequest request) {
        factory.make(request.string);
        response.version = request.string;
        presenter.versionCreatedMessage(response);
    }

}
