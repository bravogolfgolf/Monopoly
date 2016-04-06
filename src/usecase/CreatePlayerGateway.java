package usecase;

import entitiies.Player;

public interface CreatePlayerGateway {
    boolean save(Player player);
    int numberOfPlayers();
}
