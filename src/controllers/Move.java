package game.controllers;

import game.display.Console;
import game.entities.Dice;
import game.interactors.Interactor;
import game.parser.ControllerConsole;
import game.presenters.Presenter;

import java.io.IOException;

public class Move extends Controller {

    private final Interactor interactor;
    private final ControllerPresenter presenter;
    private final ControllerConsole console;
    private final ControllerRequest request = new ControllerRequest();
    private final Dice dice;

    public Move(Interactor interactor, Presenter presenter, Console console, Dice dice) {
        this.interactor = interactor;
        this.presenter = presenter;
        this.console = console;
        this.dice = dice;
    }

    @Override
    public void execute() throws IOException {
        request.dice = dice;
        interactor.handle(request);
        console.write(presenter.getFormattedMessage());
    }
}
