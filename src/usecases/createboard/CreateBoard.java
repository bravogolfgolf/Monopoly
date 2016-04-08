package usecases.createboard;

import entitiies.Board;
import presenters.Presenter;
import usecases.Interactor;
import usecases.Request;

import java.io.IOException;

public class CreateBoard implements Interactor {
    private final Presenter presenter;
    private final BoardFactory factory;

    public CreateBoard(Presenter presenter, BoardFactory factory) {
        this.presenter = presenter;
        this.factory = factory;
    }

    @Override
    public void handle(Request inputRequest) throws IOException {
        CreateBoardRequest request = (CreateBoardRequest) inputRequest;
        CreateBoardResponse response = new CreateBoardResponse();
        Board board = factory.make(request.version);
        response.message = board.getVersion();
        presenter.present(response);
    }
}
