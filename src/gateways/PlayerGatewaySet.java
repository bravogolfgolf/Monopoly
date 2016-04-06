package gateways;

import entitiies.Player;
import usecase.CreatePlayerGateway;

import java.util.HashSet;
import java.util.Set;


public class PlayerGatewaySet implements CreatePlayerGateway {

    private Set<Player> players = new HashSet<>();

    @Override
    public boolean save(Player player) {
        return players.add(player);
    }

    public int numberOfPlayers(){
        return players.size();
    }
}
