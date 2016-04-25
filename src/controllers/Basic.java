package game.controllers;

import game.parser.ControllerConsole;

import java.io.IOException;

public class Basic extends Controller {

    public Basic(ControllerInteractor interactor, ControllerPresenter presenter, ControllerConsole console) {
        super.interactor = interactor;
        super.presenter = presenter;
        super.console = console;
    }

    @Override
    public void handle(String text) throws IOException {
        request.string = text;
        interactor.handle(request);
        console.write(presenter.getFormattedMessage());
    }
}