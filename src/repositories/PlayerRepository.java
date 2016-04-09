package repositories;

import entitiies.Player;
import main.PlayerGateway;

import java.util.HashSet;
import java.util.Set;


public final class PlayerRepository implements PlayerGateway {

    private final Set<Player> players = new HashSet<>();

    @Override
    public boolean save(Player player) {
        return players.add(player);
    }

    public int count() {
        return players.size();
    }
}
