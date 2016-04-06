package usecase;

import entitiies.Player;

class CreatePlayer implements CreatePlayerInteractor {

    private static final int PLAYER_LIMIT = 8;
    private final CreatePlayerPresenter presenter;
    private final CreatePlayerGateway gateway;

    CreatePlayer(CreatePlayerPresenter presenter, CreatePlayerGateway gateway) {
        this.presenter = presenter;
        this.gateway = gateway;
    }

    @Override
    public void createPlayer(CreatePlayerRequest request) {
        CreatePlayerResponse response = new CreatePlayerResponse();

        if (isValid(request)) {

            if (gateway.numberOfPlayers() < PLAYER_LIMIT) {

                Player player = new Player(request.token);

                if (gateway.save(player)) {
                    response.message = "Player created with token.";
                    response.token = player.getToken();

                } else {
                    response.message = "Token already in use.";
                    response.token = null;
                }

            } else {
                response.message = "Exceeded eight player limit.";
                response.token = null;
            }

        } else {
            response.message = "Invalid request.";
            response.token = null;
        }
        presenter.presentResponse(response);
    }

    private boolean isValid(CreatePlayerRequest request) {
        return request.token != null;
    }
}
