package game.controllers.writerreader;

import game.controllers.Controller;
import game.parser.ControllerConsole;

import java.io.IOException;

public class WriterReader extends Controller {

    private final ReaderPresenter presenter;

    public WriterReader(ReaderPresenter presenter, ControllerConsole console) {
        super(console);
        this.presenter = presenter;
    }

    @Override
    public void execute() throws IOException {
        presenter.startTurnMessage();
        console.write(presenter.getFormattedMessage());
    }

    @Override
    public void handle(String text) throws IOException {

    }
}
