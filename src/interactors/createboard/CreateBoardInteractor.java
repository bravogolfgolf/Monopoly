package game.interactors.createboard;

import game.controllers.Interactor;
import game.controllers.Presenter;
import game.interactors.BoardGateway;
import game.interactors.Request;

public class CreateBoardInteractor implements Interactor {
    private final Presenter presenter;
    private final BoardGateway gateway;

    public CreateBoardInteractor(Presenter presenter, BoardGateway gateway) {
        this.presenter = presenter;
        this.gateway = gateway;
    }

    @Override
    public void handle(Request request) {
        CreateBoardResponse response = new CreateBoardResponse();
        CreateBoardRequest createBoardRequest = (CreateBoardRequest) request;

        if (createBoardRequest.version == null) {
            presenter.boardPromptMessage();
            response.versions = gateway.getAvailableBoards();
            presenter.availableBoardsMessage(response);

        } else {
            if (gateway.isAvailable(createBoardRequest.version)) {
                gateway.create(createBoardRequest.version);
                response.versions = new String[]{createBoardRequest.version};
                presenter.boardCreatedMessage(response);
            } else {
                presenter.boardPromptMessage();
                response.versions = gateway.getAvailableBoards();
                presenter.availableBoardsMessage(response);
            }
        }
    }
}
