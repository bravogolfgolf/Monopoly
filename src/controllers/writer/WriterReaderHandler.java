package game.controllers.writer;

import game.controllers.Controller;
import game.parser.ControllerConsole;

import java.io.IOException;

public class WriterReaderHandler extends Controller {

    private final WriterParser parser;
    private final WriterInteractor interactor;
    private final WriterPresenter presenter;
    private final ReaderRequest request = new ReaderRequest();

    public WriterReaderHandler(WriterParser parser, WriterInteractor interactor, WriterPresenter presenter, ControllerConsole console) {
        super(console);
        this.parser = parser;
        this.interactor = interactor;
        this.presenter = presenter;
    }

    @Override
    public void execute() throws IOException {
        interactor.handle();
        parser.setMap(presenter.returnAndClearMenuMap());
        console.write(presenter.getFormattedMessage());
        read();
    }

    @Override
    public void handle(String text) throws IOException {
        request.string = text;
        interactor.handle(request);
        console.write(presenter.getFormattedMessage());
    }
}
