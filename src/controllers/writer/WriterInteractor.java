package game.controllers.writer;

public interface WriterInteractor {

    void handle();

    void handle(ReaderRequest request);
}
