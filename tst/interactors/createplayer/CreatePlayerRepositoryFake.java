package game.interactors.createplayer;

import game.repositories.PlayerRepositoryImpl;

class CreatePlayerRepositoryFake extends PlayerRepositoryImpl {
    boolean verifyPlayerLimitExceededCalled = false;
    boolean verifyCreateCalled = false;
    boolean verifyCreateCalledEightTimes = false;
    private int createCalledCounter = 0;

    @Override
    public boolean create(String token) {
        createCalledCounter++;
        verifyCreateCalledEightTimes = (createCalledCounter == 8);
        verifyCreateCalled = true;
        return super.create(token);
    }

    @Override
    public boolean playerLimitExceeded() {
        verifyPlayerLimitExceededCalled = true;
        return super.playerLimitExceeded();
    }
}
