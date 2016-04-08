package usecases.createplayer;

import entitiies.Player;

public interface CreatePlayerGateway {
    boolean save(Player player);

    int count();
}
