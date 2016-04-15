package game.controllers.createPlayer;

import game.interactors.createplayer.CreatePlayerGateway;

class CreatePlayerGatewayDummy implements CreatePlayerGateway {

    @Override
    public boolean create(String token) {
        return false;
    }

    @Override
    public boolean playerLimitExceeded() {
        return false;
    }

    @Override
    public String[] getAvailableTokens() {
        return new String[0];
    }
}
