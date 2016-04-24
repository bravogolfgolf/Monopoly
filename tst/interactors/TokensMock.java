package game.interactors;

import game.entities.Token;
import game.interactors.createplayer.CreatePlayerTokensGateway;
import game.interactors.options.OptionsTokensGateway;

import java.util.Set;

class TokensMock implements CreatePlayerTokensGateway, OptionsTokensGateway {

    boolean verifyGetAvailableTokens = false;
    boolean verifyRemoveTokenCalled = false;

    @Override
    public void removeToken(Token token) {
        verifyRemoveTokenCalled = true;
    }

    @Override
    public Set<Token> getAvailableTokens() {
        verifyGetAvailableTokens = true;
        return null;
    }
}
