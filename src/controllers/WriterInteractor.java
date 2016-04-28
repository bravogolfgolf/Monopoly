package game.controllers;

public interface WriterInteractor {

    void handle();

    void handle(ReaderRequest request);
}
