package game.interactors.createplayer;

import game.entitiies.Token;
import game.repositories.PlayerRepositoryImpl;

import java.util.Set;

class CreatePlayerRepositoryFake extends PlayerRepositoryImpl {

    private int createCalledCounter = 0;
    boolean verifyPlayerLimitExceededCalled = false;
    boolean verifyCreateCalled = false;
    boolean verifyCreateCalledEightTimes = false;

    CreatePlayerRepositoryFake(Set<Token> tokens) {
        super(tokens);
    }

    @Override
    public boolean create(String request) {
        createCalledCounter++;
        verifyCreateCalledEightTimes = (createCalledCounter == 8);
        verifyCreateCalled = true;
        return !request.equals("InValid") && super.create(request);
    }

    @Override
    public boolean playerLimitExceeded() {
        verifyPlayerLimitExceededCalled = true;
        return super.playerLimitExceeded();
    }
}
