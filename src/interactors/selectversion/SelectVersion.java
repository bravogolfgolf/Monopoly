package game.interactors.selectversion;

import game.controllers.ControllerInteractor;
import game.controllers.InteractorRequest;

public class SelectVersion implements ControllerInteractor {

    private final SelectVersionPresenter presenter;
    private final SelectVersionFactory factory;
    private final SelectVersionResponse response = new SelectVersionResponse();

    public SelectVersion(SelectVersionPresenter presenter, SelectVersionFactory factory) {
        this.presenter = presenter;
        this.factory = factory;
    }

    @Override
    public void handle(InteractorRequest request) {
        factory.make(request.string);
        response.version = request.string;
        presenter.versionCreatedMessage(response);
    }

}
