package interactors.createboard;

import entitiies.Board;
import interactors.Interactor;
import interactors.Request;
import presenters.Presenter;

import java.io.IOException;

public class CreateBoard implements Interactor {
    private static final String NEW_LINE = System.lineSeparator();
    private Presenter presenter;

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void handle(Request inputRequest) throws IOException {
        CreateBoardRequest request = (CreateBoardRequest) inputRequest;
        CreateBoardResponse response = new CreateBoardResponse();
        Board.setVersion(request.version);
        response.message = String.format("%s version of board created.%s", Board.getVersion(), NEW_LINE);
        presenter.present(response);
    }
}
