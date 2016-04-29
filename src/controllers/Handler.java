package game.controllers;

import game.display.Console;
import game.interactors.Interactor;
import game.parser.ControllerConsole;
import game.parser.Parser;
import game.presenters.Presenter;

import java.io.IOException;

public class Handler extends Controller {

    private final ControllerParser parser;
    private final Interactor interactor;
    private final ControllerPresenter presenter;
    private final ControllerConsole console;
    private final ControllerRequest request = new ControllerRequest();

    public Handler(Parser parser, Interactor interactor, Presenter presenter, Console console) {
        this.parser = parser;
        this.interactor = interactor;
        this.presenter = presenter;
        this.console = console;
    }

    @Override
    public void execute() throws IOException {
        interactor.handle();
        parser.setMap(presenter.returnAndClearMenuMap());
        console.write(presenter.getFormattedMessage());
        console.read();
    }

    public void handle(String text) throws IOException {
        request.string = text;
        interactor.handle(request);
        console.write(presenter.getFormattedMessage());
    }
}
