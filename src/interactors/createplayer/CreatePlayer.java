package game.interactors.createplayer;

import game.controllers.ControllerInteractor;
import game.entities.Token;
import game.interactors.InteractorRequest;
import game.interactors.InteractorResponse;

public class CreatePlayer implements ControllerInteractor {

    private final CreatePlayerPresenter presenter;
    private final CreatePlayerTokensGateway tokens;
    private final CreatePlayerGateway players;
    private final InteractorResponse response = new InteractorResponse();

    public CreatePlayer(CreatePlayerPresenter presenter, CreatePlayerTokensGateway tokens, CreatePlayerGateway players) {
        this.presenter = presenter;
        this.players = players;
        this.tokens = tokens;
    }

    @Override
    public void handle(InteractorRequest request) {
        Token token = new Token(request.string);
        tokens.removeToken(token);
        players.addWith(token);
        prepareResponse(token);
    }

    private void prepareResponse(Token token) {
        response.token = token.getDescription();
        presenter.playerCreatedMessage(response);
    }

}