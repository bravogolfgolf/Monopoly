package game.interactors.createboard;

import game.controllers.Interactor;
import game.controllers.InteractorPresenter;
import game.interactors.BoardGateway;
import game.interactors.Request;

public class CreateBoardInteractor implements Interactor {
    private final InteractorPresenter presenter;
    private final BoardGateway gateway;

    public CreateBoardInteractor(InteractorPresenter presenter, BoardGateway gateway) {
        this.presenter = presenter;
        this.gateway = gateway;
    }

    @Override
    public void handle(Request request) {
        CreateBoardResponse response = new CreateBoardResponse();
        CreateBoardRequest createBoardRequest = (CreateBoardRequest) request;

        if (createBoardRequest.version == null) {
            presenter.boardPromptMessage();

        } else {
            gateway.create(createBoardRequest.version);
            response.message = createBoardRequest.version;
            presenter.boardCreatedMessage(response);
        }
    }
}
