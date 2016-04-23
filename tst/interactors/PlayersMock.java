package game.interactors;

import game.interactors.createplayer.CreatePlayerGateway;
import game.interactors.options.OptionsPlayerGateway;
import game.interactors.selectfirst.SelectFirstPlayerGateway;

class PlayersMock implements CreatePlayerGateway, OptionsPlayerGateway, SelectFirstPlayerGateway {

    boolean verifyCreateCalled = false;
    boolean verifyGetAvailableTokens = false;
    boolean verifyRandomizePlayers = false;
    boolean verifyGetFirstPlayer = false;

    @Override
    public void create(String request) {
        verifyCreateCalled = true;
    }

    @Override
    public String[] getAvailableTokens() {
        verifyGetAvailableTokens = true;
        return new String[]{"Cat"};
    }

    @Override
    public void randomizePlayers() {
        verifyRandomizePlayers = true;
    }

    @Override
    public String getFirstPlayer() {
        verifyGetFirstPlayer = true;
        return "Cat";
    }
}
