package game.interactors.createboard;

import game.controllers.Presenter;
import game.controllers.createBoard.CreateBoardInteractor;

public class CreateBoard implements CreateBoardInteractor {
    private final Presenter presenter;
    private final CreateBoardGateway board;
    private final CreateBoardResponse response = new CreateBoardResponse();

    public CreateBoard(Presenter presenter, CreateBoardGateway board) {
        this.presenter = presenter;
        this.board = board;
    }

    @Override
    public void handle(CreateBoardRequest request) {

        if (isNull(request)) {
            if (requestedBoardIsAvailable(request)) boardCreatedMessage(response, request);
            else boardPromptAndAvailableBoardsMessages();
        } else boardPromptAndAvailableBoardsMessages();
    }

    private boolean isNull(CreateBoardRequest createBoardRequest) {
        return createBoardRequest.version != null;
    }

    private boolean requestedBoardIsAvailable(CreateBoardRequest createBoardRequest) {
        return board.isAvailable(createBoardRequest.version);
    }

    private void boardCreatedMessage(CreateBoardResponse response, CreateBoardRequest createBoardRequest) {
        board.create(createBoardRequest.version);
        response.versions = new String[]{createBoardRequest.version};
        presenter.boardCreatedMessage(response);
    }

    public void boardPromptAndAvailableBoardsMessages() {
        presenter.boardPromptMessage();
        response.versions = board.getAvailableBoards();
        presenter.availableBoardsMessage(response);
    }
}
