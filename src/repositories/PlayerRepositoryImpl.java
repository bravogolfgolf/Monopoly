package game.repositories;

import game.entitiies.Player;
import game.entitiies.Token;
import game.factories.SetupGamePlayerGateway;
import game.interactors.createplayer.CreatePlayerGateway;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerRepositoryImpl implements CreatePlayerGateway, SetupGamePlayerGateway {

    private static final int PLAYER_LIMIT = 8;
    private final Set<Player> players = new HashSet<>();

    @Override
    public boolean create(String token) {
        Player player = new Player(token);
        return players.add(player);
    }

    int count() {
        return players.size();
    }

    @Override
    public boolean playerLimitExceeded() {
        return count() < PLAYER_LIMIT;
    }

    @Override
    public String[] getAvailableTokens() {
        return new String[0];
    }

    @Override
    public void setTokens(List<Token> tokens) {

    }

}
