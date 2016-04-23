package game.interactors.createplayer;

import game.repositories.PlayerRepositoryImpl;

import java.util.Set;

class CreatePlayerRepositoryFake extends PlayerRepositoryImpl {

    boolean verifyCreateCalled = false;
    boolean verifyGetAvailableTokens = false;

    CreatePlayerRepositoryFake(Set<Player.Token> tokens) {
        super(tokens);
    }

    @Override
    public boolean create(String request) {
        verifyCreateCalled = true;
        return !request.equals("InValid") && super.create(request);
    }

    @Override
    public String[] getAvailableTokens() {
        verifyGetAvailableTokens = true;
        return super.getAvailableTokens();
    }
}
