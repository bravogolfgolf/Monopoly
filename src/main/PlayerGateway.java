package main;

import entitiies.Player;

public interface PlayerGateway {
    boolean save(Player player);

    int count();
}
