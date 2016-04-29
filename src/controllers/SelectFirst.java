package game.controllers;

import game.display.Console;
import game.parser.ControllerConsole;
import game.presenters.Presenter;

import java.io.IOException;

public class SelectFirst extends Controller {

    private final ControllerInteractor interactor;
    private final ControllerPresenter presenter;
    private final ControllerConsole console;

    public SelectFirst(ControllerInteractor interactor, Presenter presenter, Console console) {
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
