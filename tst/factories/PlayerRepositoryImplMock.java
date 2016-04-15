package game.factories;

import game.entitiies.Token;
import game.repositories.PlayerRepositoryImpl;

import java.util.List;

class PlayerRepositoryImplMock extends PlayerRepositoryImpl {
    boolean verifySetTokensCalled = false;

    @Override
    public void setTokens(List<Token> tokens) {
        verifySetTokensCalled = true;
        super.setTokens(tokens);
    }
}
