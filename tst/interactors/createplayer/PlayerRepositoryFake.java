package game.interactors.createplayer;

import game.entitiies.Player;
import game.interactors.PlayerGateway;

import java.util.HashSet;
import java.util.Set;

public class PlayerRepositoryFake extends PlayerGateway {
    private final Set<Player> players = new HashSet<>();
    public boolean VerifyCreateMethodCalled = false;
    public boolean VerifyCountMethodCalled = false;

    @Override
    public boolean create(String token) {
        VerifyCreateMethodCalled = true;
        Player player = new Player(token);
        return players.add(player);
    }

    public int count() {
        VerifyCountMethodCalled = true;
        return players.size();
    }
}
