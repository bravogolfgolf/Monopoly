package game.controllers.setmap;

import game.controllers.basic.BasicRequest;
import game.manager.ManagerBasic;
import game.manager.ManagerMenu;
import game.parser.ControllerConsole;

import java.io.IOException;

public class Menu implements ManagerMenu, ManagerBasic {

    private final MenuParser parser;
    private final MenuInteractor interactor;
    private final MenuPresenter presenter;
    private final ControllerConsole console;
    private final BasicRequest request = new BasicRequest();

    public Menu(MenuParser parser, MenuInteractor interactor, MenuPresenter presenter, ControllerConsole console) {

        this.parser = parser;
        this.interactor = interactor;
        this.presenter = presenter;
        this.console = console;
    }

    @Override
    public void handle(String text) throws IOException {
        request.string = text;
        interactor.handle(request);
        parser.setMap(presenter.returnAndClearMenuMap());
        console.write(presenter.getFormattedMessage());
    }

    @Override
    public void handle() throws IOException {
        interactor.handle();
        parser.setMap(presenter.returnAndClearMenuMap());
        console.write(presenter.getFormattedMessage());
    }
}
