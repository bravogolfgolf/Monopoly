package game.interactors.createplayer;

import game.controllers.reader.ReaderInteractor;
import game.controllers.reader.ReaderRequest;
import game.entities.Token;

public class CreatePlayer implements ReaderInteractor {

    private final CreatePlayerPresenter presenter;
    private final CreatePlayerTokensGateway tokens;
    private final CreatePlayerGateway players;
    private final CreatePlayerResponse response = new CreatePlayerResponse();

    public CreatePlayer(CreatePlayerPresenter presenter, CreatePlayerTokensGateway tokens, CreatePlayerGateway players) {
        this.presenter = presenter;
        this.players = players;
        this.tokens = tokens;
    }

    @Override
    public void handle(ReaderRequest request) {
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