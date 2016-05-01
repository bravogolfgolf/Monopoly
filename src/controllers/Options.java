package game.controllers;

import game.display.Console;
import game.interactors.Interactor;
import game.parser.Parser;
import game.presenters.Presenter;

import java.io.IOException;

public class Options extends Controller {

    private final ControllerParser parser;
    private final Interactor interactor;
    private final ControllerPresenter presenter;
    private final ControllerConsole console;
    private final ControllerRequest request = new ControllerRequest();

    public Options(Parser parser, Interactor interactor, Presenter presenter, Console console) {
        this.parser = parser;
        this.interactor = interactor;
        this.presenter = presenter;
        this.console = console;
    }

    @Override
    public void execute() throws IOException {
        interactor.handle();
        parser.setMap(presenter.returnAndClearMenuMap());
        presenter.writeMessage();
        console.read();
    }

    public void handle(String text) throws IOException {
        request.string = text;
        interactor.handle(request);
        presenter.writeMessage();
    }
}
