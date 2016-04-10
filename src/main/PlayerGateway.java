package main;

import entitiies.Player;

public abstract class PlayerGateway {

    public static final int PLAYER_LIMIT = 8;

    public abstract boolean save(Player player);

    public abstract int count();
}
