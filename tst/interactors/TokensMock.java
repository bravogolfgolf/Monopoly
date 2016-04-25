package game.interactors;

import game.entities.Token;
import game.interactors.createplayer.CreatePlayerTokensGateway;
import game.interactors.tokenoptions.TokenOptionsTokensGateway;

import java.util.Set;
import java.util.TreeSet;

class TokensMock implements CreatePlayerTokensGateway, TokenOptionsTokensGateway {

    boolean verifyGetAvailableTokens = false;
    boolean verifyRemoveTokenCalled = false;

    @Override
    public void removeToken(Token token) {
        verifyRemoveTokenCalled = true;
    }

    @Override
    public Set<Token> getAvailableTokens() {
        verifyGetAvailableTokens = true;
        return new TreeSet<Token>() {{
            add(new Token("Cat"));
        }};
    }
}
