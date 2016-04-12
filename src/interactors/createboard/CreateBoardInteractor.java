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

        if (isNullRequest(createBoardRequest)) boardPromptAndAvailableBoardsMessages(response);
        else if (requestedBoardIsNotAvailable(createBoardRequest)) boardPromptAndAvailableBoardsMessages(response);
        else boardCreatedMessage(response, createBoardRequest);
    }

    private boolean isNullRequest(CreateBoardRequest createBoardRequest) {
        return createBoardRequest.version == null;
    }

    private boolean requestedBoardIsNotAvailable(CreateBoardRequest createBoardRequest) {
        return !gateway.isAvailable(createBoardRequest.version);
    }

    private void boardPromptAndAvailableBoardsMessages(CreateBoardResponse response) {
        presenter.boardPromptMessage();
        response.versions = gateway.getAvailableBoards();
        presenter.availableBoardsMessage(response);
    }

    private void boardCreatedMessage(CreateBoardResponse response, CreateBoardRequest createBoardRequest) {
        gateway.create(createBoardRequest.version);
        response.versions = new String[]{createBoardRequest.version};
        presenter.boardCreatedMessage(response);
    }
}
