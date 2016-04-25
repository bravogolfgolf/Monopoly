package game.controllers.basic;

import game.controllers.Controller;
import game.parser.ControllerConsole;

import java.io.IOException;

public class Basic extends Controller {

    private final BasicInteractor interactor;
    private final BasicPresenter presenter;
    private final ControllerConsole console;
    private final BasicRequest request = new BasicRequest();

    public Basic(BasicInteractor interactor, BasicPresenter presenter, ControllerConsole console) {
        this.interactor = interactor;
        this.presenter = presenter;
        this.console = console;
    }

    public void handle(String text) throws IOException {
        request.string = text;
        interactor.handle(request);
        console.write(presenter.getFormattedMessage());
    }
}