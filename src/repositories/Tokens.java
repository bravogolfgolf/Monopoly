package game.repositories;

import game.entities.Token;
import game.interactors.createplayer.CreatePlayerTokensGateway;
import game.interactors.options.OptionsTokensGateway;

import java.util.Set;

public class Tokens implements OptionsTokensGateway, CreatePlayerTokensGateway {

    private final Set<Token> tokens;

    public Tokens(Set<Token> tokens) {
        this.tokens = tokens;
    }

    @Override
    public Set<Token> getAvailableTokens() {
        return tokens;
    }

    @Override
    public void removeToken(Token token) {
        tokens.remove(token);
    }
}