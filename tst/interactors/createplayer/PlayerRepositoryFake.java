package game.interactors.createplayer;

import game.entitiies.Player;
import game.interactors.PlayerGateway;

import java.util.HashSet;
import java.util.Set;

public class PlayerRepositoryFake extends PlayerGateway {
    private final Set<Player> players = new HashSet<>();
    public boolean verifyCreate = false;
    public boolean verifyCount = false;
    private int createMethodCallCounter = 0;
    public boolean verifyCountCalledEightTimes = false;

    @Override
    public boolean create(String token) {
        verifyCreate = true;
        createMethodCallCounter++;
        verifyCountCalledEightTimes = createMethodCallCounter == 8;
        Player player = new Player(token);
        return players.add(player);
    }

    public int count() {
        verifyCount = true;
        return players.size();
    }
}
