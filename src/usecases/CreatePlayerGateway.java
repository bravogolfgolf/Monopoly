package usecases;

import entitiies.Player;

public interface CreatePlayerGateway {
    boolean save(Player player);
    int count();
}
