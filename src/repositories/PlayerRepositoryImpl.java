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
    private List<Token> tokens;

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
        String[] result = new String[tokens.size()];
        for (int i = 0; i < tokens.size(); i++) {
            result[i] = tokens.get(i).getDescription();
        }
        return result;
    }

    @Override
    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

}
