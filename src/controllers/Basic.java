package game.controllers;

import game.interactors.InteractorRequest;

import java.io.IOException;

public class Basic extends Controller {

    public Basic(ControllerView view, ControllerInteractor interactor, ControllerPresenter presenter) {
        super(view, interactor, presenter);
    }

    public void execute() throws IOException {
        interactor.userInterfaceOptions();
        view.setMap(presenter.getMenuMap());
        view.write(presenter.getFormattedMessage());
    }

    @Override
    public void handle(String text) throws IOException {
        InteractorRequest request = new InteractorRequest();
        request.string = text;
        interactor.handle(request);
        view.write(presenter.getFormattedMessage());
    }
}