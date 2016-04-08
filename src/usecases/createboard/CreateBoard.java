package usecases.createboard;

import entitiies.Board;
import presenters.Presenter;
import usecases.Interactor;
import usecases.Request;

import java.io.IOException;

public class CreateBoard implements Interactor {
    private Presenter presenter;

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void handle(Request inputRequest) throws IOException {
        CreateBoardRequest request = (CreateBoardRequest) inputRequest;
        CreateBoardResponse response = new CreateBoardResponse();
        Board.setVersion(request.version);
        response.message = Board.getVersion();
        presenter.present(response);
    }
}
