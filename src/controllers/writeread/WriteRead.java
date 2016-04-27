package game.controllers.writeread;

import game.controllers.Controller;
import game.controllers.basic.BasicPresenter;
import game.controllers.menu.MenuInteractor;
import game.parser.ControllerConsole;

import java.io.IOException;

public class WriteRead extends Controller {

    private final MenuInteractor interactor;
    private final BasicPresenter presenter;

    public WriteRead(MenuInteractor interactor, BasicPresenter presenter, ControllerConsole console) {
        super(console);
        this.interactor = interactor;
        this.presenter = presenter;

    }

    @Override
    public void execute() throws IOException {
        interactor.handle();
        console.write(presenter.getFormattedMessage());
        read();
    }

    @Override
    public void handle(String text) throws IOException {

    }
}
