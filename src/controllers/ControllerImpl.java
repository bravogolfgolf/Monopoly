package game.controllers;

import game.interactors.InteractorRequest;
import game.manager.ManagerController;

import java.io.IOException;

public class ControllerImpl implements ManagerController {

    private final ControllerView view;
    private final Interactor interactor;
    private final ControllerPresenter presenter;

    public ControllerImpl(ControllerView view, Interactor interactor, ControllerPresenter presenter) {
        this.view = view;
        this.interactor = interactor;
        this.presenter = presenter;
    }

    @Override
    public void execute() throws IOException {
        interactor.userInterfaceOptions();
        view.setMap(presenter.getMenuMap());
        updateView();
    }

    private void updateView() throws IOException {
        view.write(presenter.getFormattedMessage());
    }

    @Override
    public void handle(String text) throws IOException {
        InteractorRequest request = new InteractorRequest();
        request.string = text;
        interactor.handle(request);
        updateView();
    }
}