package game.doubles;

import game.entities.Token;
import game.interactors.tokenoptions.TokenOptionsTokensGateway;

import java.util.Set;
import java.util.TreeSet;

public class TokensMock implements TokenOptionsTokensGateway {

    public boolean verifyRemoveTokenCalled = false;
    public boolean verifyGetAvailableTokensCalled = false;

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
