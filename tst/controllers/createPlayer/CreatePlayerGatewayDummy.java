package game.controllers.createPlayer;

import game.interactors.createplayer.CreatePlayerGateway;

class CreatePlayerGatewayDummy extends CreatePlayerGateway {

    @Override
    public boolean create(String token) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }
}
