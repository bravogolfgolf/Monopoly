package game.interactors.tokenoptions;

import game.controllers.setmap.MenuInteractor;
import game.entities.Token;

import java.util.Set;

public class TokenOptions implements MenuInteractor {

    private final TokenOptionsPresenter presenter;
    private final TokenOptionsTokensGateway tokens;
    private final TokenOptionsResponse response = new TokenOptionsResponse();

    public TokenOptions(TokenOptionsPresenter presenter, TokenOptionsTokensGateway tokens) {
        this.presenter = presenter;
        this.tokens = tokens;
    }

    @Override
    public void handle() {
        prepareResponse(tokens.getAvailableTokens());
    }

    private void prepareResponse(Set<Token> tokens) {
        int counter = 0;
        String[] strings = new String[tokens.size()];
        for (Token token : tokens) {
            strings[counter++] = token.getDescription();
        }
        response.tokens = strings;
        presenter.availableTokensMessage(response);
    }
}
