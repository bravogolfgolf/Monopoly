package game.controllers;

import game.display.Console;
import game.parser.ControllerConsole;
import game.presenters.Presenter;

import java.io.IOException;

public class Writer {

    private final ReaderPresenter presenter;
    final ControllerConsole console;

    public Writer(Presenter presenter, Console console) {
        this.console = console;
        this.presenter = presenter;
    }

    void read() throws IOException {
        console.read();
    }

    public void execute() throws IOException {
        presenter.startTurnMessage();
        console.write(presenter.getFormattedMessage());
        read();
    }

    public void handle(String text) throws IOException {

    }
}
