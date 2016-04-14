package game.repositories;

import game.PlayerRepository;
import game.entitiies.Player;
import game.interactors.createplayer.CreatePlayerGateway;

import java.util.HashSet;
import java.util.Set;

public final class PlayerRepositoryImpl implements PlayerRepository, CreatePlayerGateway {

    public static final int PLAYER_LIMIT = 8;
    private final Set<Player> players = new HashSet<>();

    @Override
    public boolean create(String token) {
        Player player = new Player(token);
        return players.add(player);
    }

    public int count() {
        return players.size();
    }

    @Override
    public boolean playerLimitExceeded() {
        return count() < PLAYER_LIMIT;
    }

}
