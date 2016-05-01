package game.interactors.tokenoptions;

import game.controllers.ControllerRequest;
import game.entities.Token;
import game.interactors.Interactor;

import java.util.Set;

public abstract class TokenOptions extends Interactor {

    final TokenOptionsPresenter presenter;
    private final TokenOptionsTokensGateway tokens;
    private final TokenOptionsPlayersGateway players;
    private final TokenOptionsResponse response = new TokenOptionsResponse();

    TokenOptions(TokenOptionsPresenter presenter, TokenOptionsTokensGateway tokens, TokenOptionsPlayersGateway players) {
        this.presenter = presenter;
        this.tokens = tokens;
        this.players = players;
    }

    @Override
    public void handle() {
        sendUserInterfacePrompt();
        prepareResponse(tokens.getAvailableTokens());
        presenter.availableTokensMessage(response);
    }

    @Override
    public void handle(ControllerRequest request) {
        Token token = new Token(request.string);
        tokens.removeToken(token);
        players.add(token);
        response.token = token.getDescription();
        presenter.playerCreatedMessage(response);
    }

    private void prepareResponse(Set<Token> tokens) {
        int counter = 0;
        String[] strings = new String[tokens.size()];
        for (Token token : tokens) {
            strings[counter++] = token.getDescription();
        }
        response.tokens = strings;
    }

    abstract void sendUserInterfacePrompt();
}
