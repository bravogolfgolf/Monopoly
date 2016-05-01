package game.controllers;

import game.entities.Dice;
import game.interactors.Interactor;
import game.presenters.Presenter;

import java.io.IOException;

public class Move extends Controller {

    private final Interactor interactor;
    private final ControllerPresenter presenter;
    private final ControllerRequest request = new ControllerRequest();
    private final Dice dice;

    public Move(Interactor interactor, Presenter presenter, Dice dice) {
        this.interactor = interactor;
        this.presenter = presenter;
        this.dice = dice;
    }

    @Override
    public void execute() throws IOException {
        request.dice = dice;
        interactor.handle(request);
        presenter.writeMessage();
    }
}
