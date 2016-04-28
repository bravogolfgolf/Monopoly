package game.interactors.tokenoptions;

import game.controllers.WriterInteractor;
import game.entities.Token;

import java.util.Set;

public abstract class TokenOptions implements WriterInteractor {

    final TokenOptionsPresenter presenter;
    private final TokenOptionsTokensGateway tokens;
    private final TokenOptionsResponse response = new TokenOptionsResponse();

    TokenOptions(TokenOptionsPresenter presenter, TokenOptionsTokensGateway tokens) {
        this.presenter = presenter;
        this.tokens = tokens;
    }

    @Override
    public void handle() {
        sendUserInterfacePrompt();
        prepareResponse(tokens.getAvailableTokens());
        presenter.availableTokensMessage(response);
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
