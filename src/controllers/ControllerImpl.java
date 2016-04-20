package game.controllers;

import game.Command;
import game.interactors.InteractorRequest;
import game.view.Controller;

import java.io.IOException;

public class ControllerImpl implements Controller, Command {

    private final View view;
    private final Interactor interactor;
    private final Presenter presenter;

    public ControllerImpl(View view, Interactor interactor, Presenter presenter) {
        this.view = view;
        this.interactor = interactor;
        this.presenter = presenter;
    }

    @Override
    public void execute() throws IOException {
        view.userInterfacePrompt();
        interactor.userInterfaceOptions();
        view.setMap(presenter.getMenuMap());
        updateView();
        view.read();
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