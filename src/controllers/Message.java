package game.controllers;

import game.display.Console;
import game.interactors.Interactor;
import game.parser.ControllerConsole;
import game.presenters.Presenter;

import java.io.IOException;

public class Message extends Controller {

    private final Interactor interactor;
    private final ControllerPresenter presenter;
    private final ControllerConsole console;

    public Message(Interactor interactor, Presenter presenter, Console console) {
        this.interactor = interactor;
        this.presenter = presenter;
        this.console = console;
    }

    @Override
    public void execute() throws IOException {
        interactor.handle();
        console.write(presenter.getFormattedMessage());
    }
}
