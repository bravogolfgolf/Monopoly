package repositories;

import entitiies.Player;
import main.PlayerGateway;

import java.util.HashSet;
import java.util.Set;


public final class PlayerRepository extends PlayerGateway {

    private final Set<Player> players = new HashSet<>();

    @Override
    public boolean save(Player player) {
        return players.add(player);
    }

    @Override
    public int count() {
        return players.size();
    }

}
