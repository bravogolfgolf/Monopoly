package game.interactors.gamesetup.createplayer;

import game.controllers.ControllerInteractor;
import game.interactors.InteractorRequest;
import game.interactors.InteractorResponse;

public class CreatePlayer implements ControllerInteractor {

    private final CreatePlayerPresenter presenter;
    private final CreatePlayerGateway player;
    private final InteractorResponse response = new InteractorResponse();

    public CreatePlayer(CreatePlayerPresenter presenter, CreatePlayerGateway player) {
        this.presenter = presenter;
        this.player = player;
    }

    @Override
    public void handle(InteractorRequest request) {
         createPlayer(request);
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