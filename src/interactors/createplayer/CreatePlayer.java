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

        if (isNull(request))
            if (player.playerLimitExceeded())
                if (player.create(request.token)) playerCreatedMessage();
                else tokenInUseMessage();
            else exceededPlayerLimitMessage();
        else createPlayerPrompt();
    }

    protected void exceededPlayerLimitMessage() {
        presenter.exceededPlayerLimitMessage();
    }

    protected void playerCreatedMessage() {
        response.tokens = new String[]{request.token};
        presenter.playerCreatedMessage(response);
    }

    protected void tokenInUseMessage() {
        response.tokens = new String[]{request.token};
        presenter.tokenInUseMessage(response);
        createPlayerPrompt();
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

    private boolean isNull(CreatePlayerRequest request) {
        return request.token != null;
    }
}
