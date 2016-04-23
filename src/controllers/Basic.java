package game.controllers;

import java.io.IOException;

public class Basic extends Controller {

    public Basic(ControllerView view, ControllerInteractor interactor, ControllerPresenter presenter) {
        super(view, interactor, presenter);
    }

    @Override
    public void handle(String text) throws IOException {
        request.string = text;
        interactor.handle(request);
        view.write(presenter.getFormattedMessage());
    }
}