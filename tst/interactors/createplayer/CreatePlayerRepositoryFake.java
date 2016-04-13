package game.interactors.createplayer;

import game.entitiies.Player;

import java.util.HashSet;
import java.util.Set;

class CreatePlayerRepositoryFake extends CreatePlayerGateway {
    private final Set<Player> players = new HashSet<>();
    boolean verifyCreate = false;
    boolean verifyCount = false;
    private int createMethodCallCounter = 0;
    boolean verifyCountCalledEightTimes = false;

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
