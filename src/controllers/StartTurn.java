package game.controllers;

import game.display.Console;
import game.parser.Parser;
import game.presenters.Presenter;

import java.io.IOException;

public class StartTurn extends Controller {

    private final ControllerParser parser;
    private final ControllerPresenter presenter;
    private final ControllerConsole console;

    public StartTurn(Parser parser, Presenter presenter, Console console) {
        this.parser = parser;
        this.console = console;
        this.presenter = presenter;
    }

    @Override
    public void execute() throws IOException {
        parser.clearMap();
        presenter.startTurnMessage();
        presenter.writeMessage();
        console.read();
    }
}
