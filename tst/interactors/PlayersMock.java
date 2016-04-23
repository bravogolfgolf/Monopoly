package game.interactors;

import game.interactors.createplayer.CreatePlayerGateway;
import game.interactors.options.OptionsPlayerGateway;

class PlayersMock implements CreatePlayerGateway, OptionsPlayerGateway {

    boolean verifyCreateCalled = false;
    boolean verifyGetAvailableTokens = false;

    @Override
    public void create(String request) {
        verifyCreateCalled = true;
    }

    @Override
    public String[] getAvailableTokens() {
        verifyGetAvailableTokens = true;
        return new String[]{"Cat"};
    }
}
