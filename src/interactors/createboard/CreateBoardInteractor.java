package interactors.createboard;

import interactors.BoardGateway;
import interactors.Interactor;
import interactors.Request;
import presenters.Presenter;
import utilities.StringFormatter;

public class CreateBoardInteractor implements Interactor {
    private final Presenter presenter;
    private final BoardGateway gateway;

    public CreateBoardInteractor(Presenter presenter, BoardGateway gateway) {
        this.presenter = presenter;
        this.gateway = gateway;
    }

    @Override
    public void handle(Request inputRequest) {
        CreateBoardResponse response = new CreateBoardResponse();
        CreateBoardRequest request = (CreateBoardRequest) inputRequest;

        if (request.version == null) {
            response.message = StringFormatter.addNewLine("Select version of board you would like to use.");
            presenter.present(response);

        } else {
            gateway.setVersion(request.version);
            response.message = StringFormatter.addNewLine(String.format("%s version of board created.", gateway.getVersion()));
            presenter.present(response);
        }
    }
}
