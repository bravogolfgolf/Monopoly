package game.interactors.setupgame;

import game.controllers.Presenter;
import game.controllers.setupgame.SetupGameInteractor;

public class SetupGame implements SetupGameInteractor {
    private final Presenter presenter;
    private final SetupGameFactory factory;
    private final SetupGameResponse response = new SetupGameResponse();

    public SetupGame(Presenter presenter, SetupGameFactory factory) {
        this.presenter = presenter;
        this.factory = factory;
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
        return factory.isAvailable(setupGameRequest.version);
    }

    private void versionCreatedMessage(SetupGameResponse response, SetupGameRequest setupGameRequest) {
        factory.make(setupGameRequest.version);
        response.versions = new String[]{setupGameRequest.version};
        presenter.boardCreatedMessage(response);
    }

    public void setupGamePrompt() {
        presenter.boardPromptMessage();
        response.versions = factory.getAvailableBoards();
        presenter.availableBoardsMessage(response);
    }
}
