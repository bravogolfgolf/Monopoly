package game.interactors.createplayer;

import game.controllers.Presenter;
import game.controllers.createPlayer.CreatePlayerControllerInteractor;

public class CreatePlayerInteractor implements CreatePlayerControllerInteractor {
    private final Presenter presenter;
    private final CreatePlayerGateway repository;
    private final CreatePlayerResponse response = new CreatePlayerResponse();

    public CreatePlayerInteractor(Presenter presenter, CreatePlayerGateway repository) {
        this.presenter = presenter;
        this.repository = repository;
    }

    @Override
    public void handle(CreatePlayerRequest request) {

        if (isValid(request)) {

            if (repository.count() < CreatePlayerGateway.PLAYER_LIMIT) {

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

    private boolean isValid(CreatePlayerRequest request) {
        return request.token != null;
    }
}
