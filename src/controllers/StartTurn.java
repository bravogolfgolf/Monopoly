package game.controllers;

import game.display.Console;
import game.presenters.Presenter;

import java.io.IOException;

public class StartTurn extends Controller {

    private final ControllerPresenter presenter;
    private final ControllerConsole console;

    public StartTurn(Presenter presenter, Console console) {
        this.console = console;
        this.presenter = presenter;
    }

    @Override
    public void execute() throws IOException {
        presenter.startTurnMessage();
        presenter.writeMessage();
        console.read();
    }
}
