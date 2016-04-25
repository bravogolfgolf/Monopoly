package game.controllers.menu;

import game.controllers.Controller;
import game.parser.ControllerConsole;

import java.io.IOException;

public class Menu extends Controller {

    private final MenuParser parser;
    private final MenuInteractor interactor;
    private final MenuPresenter presenter;
    private final ControllerConsole console;

    public Menu(MenuParser parser, MenuInteractor interactor, MenuPresenter presenter, ControllerConsole console) {

        this.parser = parser;
        this.interactor = interactor;
        this.presenter = presenter;
        this.console = console;
    }

    public void handle() throws IOException {
        interactor.handle();
        parser.setMap(presenter.returnAndClearMenuMap());
        console.write(presenter.getFormattedMessage());
    }
}
