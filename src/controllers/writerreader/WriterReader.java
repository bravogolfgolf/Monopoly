package game.controllers.writerreader;

import game.controllers.Controller;
import game.controllers.ReaderPresenter;
import game.controllers.WriterInteractor;
import game.parser.ControllerConsole;

import java.io.IOException;

public class WriterReader extends Controller {

    private final WriterInteractor interactor;
    private final ReaderPresenter presenter;

    public WriterReader(WriterInteractor interactor, ReaderPresenter presenter, ControllerConsole console) {
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
