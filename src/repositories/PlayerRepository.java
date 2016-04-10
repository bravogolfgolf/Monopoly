package repositories;

import entitiies.Player;
import interactors.PlayerGateway;

import java.util.HashSet;
import java.util.Set;


public final class PlayerRepository extends PlayerGateway {

    private final Set<Player> players = new HashSet<>();

    @Override
    public boolean create(String token) {
        Player player = new Player(token);
        return players.add(player);
    }

    @Override
    public int count() {
        return players.size();
    }

}
