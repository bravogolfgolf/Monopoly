package game.factories;

import game.entitiies.Token;
import game.repositories.PlayerRepositoryImpl;

import java.util.List;

class PlayerRepositoryImplMock extends PlayerRepositoryImpl {
    boolean verifySetTokensCalled = false;

    @Override
    public boolean create(String token) {
        return super.create(token);
    }


    @Override
    public int count() {
        return super.count();
    }

    @Override
    public boolean playerLimitExceeded() {
        return super.playerLimitExceeded();
    }

    @Override
    public void setTokens(List<Token> tokens) {
        verifySetTokensCalled = true;
        super.setTokens(tokens);
    }
}
