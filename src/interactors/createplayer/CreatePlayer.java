package game.interactors.createplayer;

import game.controllers.createPlayer.CreatePlayerInteractor;

public class CreatePlayer implements CreatePlayerInteractor {

    private final CreatePlayerPresenter presenter;
    private final CreatePlayerGateway player;
    private final CreatePlayerResponse response = new CreatePlayerResponse();
    private CreatePlayerRequest request;

    public CreatePlayer(CreatePlayerPresenter presenter, CreatePlayerGateway player) {
        this.presenter = presenter;
        this.player = player;
    }

    @Override
    public void handle(CreatePlayerRequest request) {
        this.request = request;

        if (player.playerLimitExceeded())
            exceededPlayerLimitMessage();
        else playerCreatedMessage();
    }

    private void exceededPlayerLimitMessage() {
        presenter.exceededPlayerLimitMessage();
    }

    private void playerCreatedMessage() {
        player.create(request.token);
        response.tokens = new String[]{request.token};
        presenter.playerCreatedMessage(response);
    }

    @Override
    public void createPlayerPrompt() {
        presenter.createPlayerPromptMessage();
        availableTokensMessage();
    }

    @Override
    public void availableTokensMessage() {
        response.tokens = player.getAvailableTokens();
        presenter.availableTokensMessage(response);
    }
}