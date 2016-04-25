package game.controllers;

import java.io.IOException;

public class SetMap extends Controller {

    private final SetMapView view;

    public SetMap(SetMapView view, ControllerInteractor interactor, ControllerPresenter presenter) {
        this.view = view;
        super.interactor = interactor;
        super.presenter = presenter;
    }

    @Override
    public void handle(String text) throws IOException {
        request.string = text;
        interactor.handle(request);
        view.setMap(presenter.getMenuMap());
        view.write(presenter.getFormattedMessage());
    }
}
