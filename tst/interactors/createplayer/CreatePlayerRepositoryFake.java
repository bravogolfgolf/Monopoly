package game.interactors.createplayer;

import game.entities.Players;

import java.util.Set;

class CreatePlayerRepositoryFake extends Players {

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
