package game.interactors.createplayer;

import game.repositories.PlayerRepositoryImpl;

class CreatePlayerRepositoryMock extends PlayerRepositoryImpl {

    boolean verifyCreateCalled = false;
    private int createCalledCounter = 0;
    boolean verifyCreateCalledEightTimes = false;
    boolean verifyPlayerLimitExceededCalled = false;
    boolean verifyGetAvailableTokensCalled = false;

    @Override
    public boolean create(String token) {
        verifyCreateCalled = true;
        createCalledCounter++;
        verifyCreateCalledEightTimes = (createCalledCounter == 8);
        return super.create(token);
    }

    @Override
    public boolean playerLimitExceeded() {
        verifyPlayerLimitExceededCalled = true;
        return super.playerLimitExceeded();
    }

    @Override
    public String[] getAvailableTokens() {
        verifyGetAvailableTokensCalled = true;
        return super.getAvailableTokens();
    }
}
