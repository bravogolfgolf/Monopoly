package game.controllers;

import java.io.IOException;

public class Basic extends Controller {

    private final BasicView view;

    public Basic(BasicView view, ControllerInteractor interactor, ControllerPresenter presenter) {
        this.view = view;
        super.interactor = interactor;
        super.presenter = presenter;
    }

    @Override
    public void handle(String text) throws IOException {
        request.string = text;
        interactor.handle(request);
        view.write(presenter.getFormattedMessage());
    }
}