package game.controllers;

import game.parser.ControllerConsole;

import java.io.IOException;

public class SetMap extends Controller {

    private final SetMapParser parser;

    public SetMap(SetMapParser parser, ControllerInteractor interactor, ControllerPresenter presenter, ControllerConsole console) {
        this.parser = parser;
        super.interactor = interactor;
        super.presenter = presenter;
        super.console = console;
    }

    @Override
    public void handle(String text) throws IOException {
        request.string = text;
        interactor.handle(request);
        parser.setMap(presenter.getMenuMap());
        console.write(presenter.getFormattedMessage());
    }
}
