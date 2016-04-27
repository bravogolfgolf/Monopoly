package game.controllers.reader;

import game.controllers.Controller;
import game.controllers.ReaderPresenter;
import game.parser.ControllerConsole;

import java.io.IOException;

public class Reader extends Controller {

    private final ReaderInteractor interactor;
    private final ReaderPresenter presenter;
    private final ReaderRequest request = new ReaderRequest();

    public Reader(ReaderInteractor interactor, ReaderPresenter presenter, ControllerConsole console) {
        super(console);
        this.interactor = interactor;
        this.presenter = presenter;
    }

    @Override
    public void execute() throws IOException {
        read();
    }

    @Override
    public void handle(String text) throws IOException {
        request.string = text;
        interactor.handle(request);
        console.write(presenter.getFormattedMessage());
    }
}