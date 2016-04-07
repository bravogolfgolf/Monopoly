package repositories;

import entitiies.Player;
import usecases.CreatePlayerGateway;

import java.util.HashSet;
import java.util.Set;


public class PlayerRepository implements CreatePlayerGateway {

    private final Set<Player> players = new HashSet<>();

    @Override
    public boolean save(Player player) {
        return players.add(player);
    }

    public int count(){
        return players.size();
    }
}
