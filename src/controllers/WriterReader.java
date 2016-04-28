package game.controllers;

import game.display.Console;
import game.presenters.Presenter;

import java.io.IOException;

public class WriterReader extends Writer {

    private final ReaderPresenter presenter;
    final WriterInteractor interactor;

    public WriterReader(WriterInteractor interactor, Presenter presenter, Console console) {
        super(presenter, console);
        this.presenter = presenter;
        this.interactor = interactor;
    }

    @Override
    public void execute() throws IOException {
        interactor.handle();
        console.write(presenter.getFormattedMessage());
    }
}
