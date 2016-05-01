package game.controllers;

import game.interactors.Interactor;
import game.presenters.Presenter;

import java.io.IOException;

public class Message extends Controller {

    private final Interactor interactor;
    private final ControllerPresenter presenter;

    public Message(Interactor interactor, Presenter presenter) {
        this.interactor = interactor;
        this.presenter = presenter;
    }

    @Override
    public void execute() throws IOException {
        interactor.handle();
        presenter.writeMessage();
    }
}
