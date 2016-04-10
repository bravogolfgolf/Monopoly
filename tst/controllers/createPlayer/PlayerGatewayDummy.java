package controllers.createPlayer;

import entitiies.Player;
import main.PlayerGateway;

public class PlayerGatewayDummy extends PlayerGateway {
    @Override
    public boolean save(Player player) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }
}
