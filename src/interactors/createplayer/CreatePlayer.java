package game.interactors.createplayer;

import game.controllers.Interactor;
import game.interactors.InteractorRequest;

public class CreatePlayer implements Interactor {

    private final CreatePlayerPresenter presenter;
    private final CreatePlayerGateway player;
    private final CreatePlayerResponse response = new CreatePlayerResponse();
    private InteractorRequest request;

    public CreatePlayer(CreatePlayerPresenter presenter, CreatePlayerGateway player) {
        this.presenter = presenter;
        this.player = player;
    }

    @Override
    public void handle(InteractorRequest request) {
        this.request = request;

        if (player.playerLimitExceeded())
            exceededPlayerLimitMessage();
        else playerCreatedMessage();
    }

    private void exceededPlayerLimitMessage() {
        presenter.exceededPlayerLimitMessage();
    }

    private void playerCreatedMessage() {
        player.create(request.string);
        response.tokens = new String[]{request.string};
        presenter.playerCreatedMessage(response);
    }

    @Override
    public void userInterfacePrompt() {
        presenter.createPlayerPromptMessage();
        userInterfaceOptions();
    }

    @Override
    public void userInterfaceOptions() {
        response.tokens = player.getAvailableTokens();
        presenter.availableTokensMessage(response);
    }
}