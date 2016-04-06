package usecase;

import entitiies.Player;

class CreatePlayer implements CreatePlayerInteractor {

    private CreatePlayerPresenter presenter;
    private CreatePlayerGateway gateway;

    CreatePlayer(CreatePlayerPresenter presenter, CreatePlayerGateway gateway) {
        this.presenter = presenter;
        this.gateway = gateway;
    }

    @Override
    public void createPlayer(CreatePlayerRequest request) {
        CreatePlayerResponse response = new CreatePlayerResponse();

        if (isValid(request)) {
            Player player = new Player(request.token);
            if (gateway.save(player)) {
                response.message = "Player created with token.";
                response.token = player.getToken();
            } else {
                response.message = "Token already in use.";
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
