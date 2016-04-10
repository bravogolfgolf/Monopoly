package controllers.createPlayer;

import interactors.PlayerGateway;

public class PlayerGatewayDummy extends PlayerGateway {

    @Override
    public boolean create(String token) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }
}
