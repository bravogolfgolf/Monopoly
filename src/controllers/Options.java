package game.controllers;

import game.display.Console;
import game.interactors.Interactor;
import game.presenters.Presenter;

import java.io.IOException;

public class Options extends Controller {

    private final Interactor interactor;
    private final ControllerPresenter presenter;
    private final ControllerConsole console;
    private final ControllerRequest request = new ControllerRequest();

    public Options(Interactor interactor, Presenter presenter, Console console) {
        this.interactor = interactor;
        this.presenter = presenter;
        this.console = console;
    }

    @Override
    public void execute() throws IOException {
        interactor.handle();
        presenter.writeMessage();
        console.read();
    }

    public void handle(String text) throws IOException {
        request.string = text;
        interactor.handle(request);
        presenter.writeMessage();
    }
}
