package game.interactors.createplayer;

import game.controllers.ControllerInteractor;
import game.entities.Token;
import game.interactors.InteractorRequest;
import game.interactors.InteractorResponse;

public class CreatePlayer implements ControllerInteractor {

    private final CreatePlayerPresenter presenter;
    private final CreatePlayerGateway players;
    private final InteractorResponse response = new InteractorResponse();

    public CreatePlayer(CreatePlayerPresenter presenter, CreatePlayerGateway players) {
        this.presenter = presenter;
        this.players = players;
    }

    @Override
    public void handle(InteractorRequest request) {
        Token token = new Token(request.string);
        players.create(token);
        response.token = players.getPlayer(token);
        presenter.playerCreatedMessage(response);
    }

}