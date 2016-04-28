package game.controllers;

import game.display.Console;
import game.presenters.Presenter;

import java.io.IOException;

public class WriterReaderHandler extends WriterReader {

    private final WriterParser parser;
    private final ReaderRequest request = new ReaderRequest();
    private final WriterPresenter presenter;

    public WriterReaderHandler(WriterParser parser, WriterInteractor interactor, Presenter presenter, Console console) {
        super(interactor, presenter, console);
        this.parser = parser;
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
