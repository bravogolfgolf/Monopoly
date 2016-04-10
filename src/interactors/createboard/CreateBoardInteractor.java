package interactors.createboard;

import interactors.BoardGateway;
import interactors.Interactor;
import interactors.Request;
import presenters.Presenter;

public class CreateBoardInteractor implements Interactor {
    private static final String NEW_LINE = System.lineSeparator();
    private final Presenter presenter;
    private final BoardGateway gateway;

    public CreateBoardInteractor(Presenter presenter, BoardGateway gateway) {
        this.presenter = presenter;
        this.gateway = gateway;
    }

    @Override
    public void handle(Request inputRequest) {
        CreateBoardRequest request = (CreateBoardRequest) inputRequest;
        CreateBoardResponse response = new CreateBoardResponse();
        gateway.setVersion(request.version);
        response.message = String.format("%s version of board created.%s", gateway.getVersion(), NEW_LINE);
        presenter.present(response);
    }
}
