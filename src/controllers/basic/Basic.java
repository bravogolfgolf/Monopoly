package game.controllers.basic;

import game.controllers.Controller;
import game.manager.ManagerBasic;
import game.parser.ControllerConsole;

import java.io.IOException;

public class Basic extends Controller implements ManagerBasic {

    private final BasicInteractor interactor;
    private final BasicPresenter presenter;
    private final BasicRequest request = new BasicRequest();

    public Basic(BasicInteractor interactor, BasicPresenter presenter, ControllerConsole console) {
        super(console);
        this.interactor = interactor;
        this.presenter = presenter;
    }

    @Override
    public void execute() throws IOException {

    }

    @Override
    public void handle(String text) throws IOException {
        request.string = text;
        interactor.handle(request);
        console.write(presenter.getFormattedMessage());
    }
}