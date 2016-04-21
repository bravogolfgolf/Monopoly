package game.repositories;

import game.entities.Player;
import game.entities.Token;
import game.interactors.createplayer.CreatePlayerGateway;

import java.util.HashSet;
import java.util.Set;

public class PlayerRepositoryImpl implements CreatePlayerGateway {

    private final Set<Player> players = new HashSet<>();
    private final Set<Token> tokens;

    public PlayerRepositoryImpl(Set<Token> tokens) {
        this.tokens = tokens;
    }

    @Override
    public boolean create(String request) {
        Token token = new Token(request);
        tokens.remove(token);
        Player player = new Player(token);
        return players.add(player);
    }

    @Override
    public String[] getAvailableTokens() {
        String[] result = new String[tokens.size()];
        int counter = 0;
        for (Token token : tokens) {
            result[counter++] = token.getDescription();
        }
        return result;
    }

}
