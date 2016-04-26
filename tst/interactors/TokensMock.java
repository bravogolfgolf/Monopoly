package game.interactors;

import game.entities.Token;
import game.interactors.createplayer.CreatePlayerTokensGateway;
import game.interactors.tokenoptions.TokenOptionsTokensGateway;

import java.util.Set;
import java.util.TreeSet;

class TokensMock implements CreatePlayerTokensGateway, TokenOptionsTokensGateway {

    boolean verifyRemoveTokenCalled = false;
    boolean verifyGetAvailableTokensCalled = false;

    @Override
    public void removeToken(Token token) {
        verifyRemoveTokenCalled = true;
    }

    @Override
    public Set<Token> getAvailableTokens() {
        verifyGetAvailableTokensCalled = true;
        return new TreeSet<Token>() {{
            add(new Token("Cat"));
        }};
    }
}
