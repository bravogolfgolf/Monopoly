package game.controllers;

import java.io.IOException;

public class SetMap extends Controller {

    public SetMap(ControllerView view, ControllerInteractor interactor, ControllerPresenter presenter) {
        super(view, interactor, presenter);
    }

    @Override
    public void handle(String text) throws IOException {
        request.string = text;
        interactor.handle(request);
        view.setMap(presenter.getMenuMap());
        view.write(presenter.getFormattedMessage());
    }
}
