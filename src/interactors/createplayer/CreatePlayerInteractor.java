package game.interactors.createplayer;

import game.controllers.Interactor;
import game.controllers.Presenter;
import game.interactors.PlayerGateway;
import game.interactors.Request;

public class CreatePlayerInteractor implements Interactor {
    private final Presenter presenter;
    private final PlayerGateway gateway;

    public CreatePlayerInteractor(Presenter presenter, PlayerGateway gateway) {
        this.presenter = presenter;
        this.gateway = gateway;
    }

    @Override
    public void handle(Request request) {
        CreatePlayerResponse response = new CreatePlayerResponse();
        CreatePlayerRequest createPlayerRequest = (CreatePlayerRequest) request;

        if (isValid(createPlayerRequest)) {

            if (gateway.count() < PlayerGateway.PLAYER_LIMIT) {

                if (gateway.create(createPlayerRequest.token)){
                    response.message = createPlayerRequest.token;
                    presenter.playerCreatedMessage(response);
                }

                else {
                    response.message = createPlayerRequest.token;
                    presenter.tokenInUseMessage(response);
                }

            } else presenter.exceededPlayerLimitMessage();

        } else presenter.playerPromptMessage();

    }

    private boolean isValid(CreatePlayerRequest request) {
        return request.token != null;
    }
}
