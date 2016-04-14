package game.interactors.createplayer;

import game.controllers.Presenter;
import game.controllers.createPlayer.CreatePlayerInteractor;

public class CreatePlayer implements CreatePlayerInteractor {
    private final Presenter presenter;
    private final CreatePlayerGateway repository;
    private final CreatePlayerResponse response = new CreatePlayerResponse();

    public CreatePlayer(Presenter presenter, CreatePlayerGateway repository) {
        this.presenter = presenter;
        this.repository = repository;
    }

    @Override
    public void handle(CreatePlayerRequest request) {

        if (isNull(request)) {

            if (repository.playerLimitExceeded()) {

                if (repository.create(request.token)){
                    response.tokens = new String[]{request.token};
                    presenter.playerCreatedMessage(response);
                }

                else {
                    response.tokens = new String[]{request.token};
                    presenter.tokenInUseMessage(response);
                }

            } else presenter.exceededPlayerLimitMessage();

        } else presenter.playerPromptMessage();

    }

    private boolean isNull(CreatePlayerRequest request) {
        return request.token != null;
    }
}
