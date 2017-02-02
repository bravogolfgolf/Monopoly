package game.repositories;

import game.entities.Token;
import game.interactors.tokenoptions.TokenOptionsTokensGateway;

import java.util.Set;

public class Tokens implements TokenOptionsTokensGateway {

    private final Set<Token> tokens;

    public Tokens(Set<Token> tokens) {
        this.tokens = tokens;
    }

    @Override
    public Set<Token> getAvailableTokens() {
        return tokens;
    }

    @Override
    public Token createToken(String text) {
        Token token = new Token(text);
        tokens.remove(token);
        return token;
    }
}
