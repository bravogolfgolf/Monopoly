package game.controllers;

import java.io.IOException;

public class SetMap extends Controller {

    public SetMap(ControllerView view, ControllerInteractor interactor, ControllerPresenter presenter) {
        super(view, interactor, presenter);
    }

    @Override
    public void execute() throws IOException {

    }

    @Override
    public void handle(String text) throws IOException {
        interactor.userInterfaceOptions();
        view.setMap(presenter.getMenuMap());
        view.write(presenter.getFormattedMessage());
    }
}
