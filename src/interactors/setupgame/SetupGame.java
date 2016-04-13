package game.interactors.setupgame;

import game.controllers.Presenter;
import game.controllers.setupgame.SetupGameInteractor;

public class SetupGame implements SetupGameInteractor {
    private final Presenter presenter;
    private final SetupGameGateway board;
    private final SetupGameResponse response = new SetupGameResponse();

    public SetupGame(Presenter presenter, SetupGameGateway board) {
        this.presenter = presenter;
        this.board = board;
    }

    @Override
    public void handle(SetupGameRequest request) {

        if (isNull(request)) {
            if (requestedVersionIsAvailable(request)) versionCreatedMessage(response, request);
            else setupGamePrompt();
        } else setupGamePrompt();
    }

    private boolean isNull(SetupGameRequest setupGameRequest) {
        return setupGameRequest.version != null;
    }

    private boolean requestedVersionIsAvailable(SetupGameRequest setupGameRequest) {
        return board.isAvailable(setupGameRequest.version);
    }

    private void versionCreatedMessage(SetupGameResponse response, SetupGameRequest setupGameRequest) {
        board.create(setupGameRequest.version);
        response.versions = new String[]{setupGameRequest.version};
        presenter.boardCreatedMessage(response);
    }

    public void setupGamePrompt() {
        presenter.boardPromptMessage();
        response.versions = board.getAvailableBoards();
        presenter.availableBoardsMessage(response);
    }
}
