package game.interactors.createplayer;

import game.controllers.Interactor;
import game.interactors.InteractorRequest;
import game.interactors.InteractorResponse;

public class CreatePlayer implements Interactor {

    private final CreatePlayerPresenter presenter;
    private final CreatePlayerGateway player;
    private final InteractorResponse response = new InteractorResponse();

    public CreatePlayer(CreatePlayerPresenter presenter, CreatePlayerGateway player) {
        this.presenter = presenter;
        this.player = player;
    }

    @Override
    public void handle(InteractorRequest request) {

        if (player.playerLimitExceeded())
            exceededPlayerLimit();
        else createPlayer(request);
    }

    private void exceededPlayerLimit() {
        presenter.exceededPlayerLimitMessage();
    }

    private void createPlayer(InteractorRequest request) {
        player.create(request.string);
        response.options = new String[]{request.string};
        presenter.playerCreatedMessage(response);
    }

    @Override
    public void userInterfaceOptions() {
        response.options = player.getAvailableTokens();
        presenter.availableTokensMessage(response);
    }
}