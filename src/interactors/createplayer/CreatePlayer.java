package game.interactors.createplayer;

import game.controllers.Interactor;
import game.interactors.InteractorRequest;
import game.interactors.InteractorResponse;

public class CreatePlayer implements Interactor {

    private final CreatePlayerPresenter presenter;
    private final CreatePlayerGateway player;
    private final InteractorResponse response = new InteractorResponse();
    private InteractorRequest request;

    public CreatePlayer(CreatePlayerPresenter presenter, CreatePlayerGateway player) {
        this.presenter = presenter;
        this.player = player;
    }

    @Override
    public void handle(InteractorRequest request) {
        this.request = request;

        if (player.playerLimitExceeded())
            exceededPlayerLimit();
        else createPlayer();
    }

    private void exceededPlayerLimit() {
        presenter.exceededPlayerLimitMessage();
    }

    private void createPlayer() {
        player.create(request.string);
        response.options = new String[]{request.string};
        presenter.playerCreatedMessage(response);
    }

    @Override
    public void userInterfacePrompt() {
        presenter.createPlayerPromptMessage();
        getUserInterfaceOptions();
        presenter.availableTokensMessage(response);
    }

    @Override
    public void userInterfaceOptions() {
        getUserInterfaceOptions();
        presenter.userInterfaceOptionsMessage(response);
    }

    private void getUserInterfaceOptions(){
        response.options = player.getAvailableTokens();

    }
}