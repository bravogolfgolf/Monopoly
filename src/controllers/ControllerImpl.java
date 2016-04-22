package game.controllers;

import game.interactors.InteractorRequest;

import java.io.IOException;

public class ControllerImpl {

    private final View view;
    private final Interactor interactor;
    private final Presenter presenter;

    public ControllerImpl(View view, Interactor interactor, Presenter presenter) {
        this.view = view;
        this.interactor = interactor;
        this.presenter = presenter;
    }

    public void execute() throws IOException {
        interactor.userInterfaceOptions();
        view.setMap(presenter.getMenuMap());
        updateView();
    }

    private void updateView() throws IOException {
        view.write(presenter.getFormattedMessage());
    }

    public void handle(String text) throws IOException {
        InteractorRequest request = new InteractorRequest();
        request.string = text;
        interactor.handle(request);
        updateView();
    }
}