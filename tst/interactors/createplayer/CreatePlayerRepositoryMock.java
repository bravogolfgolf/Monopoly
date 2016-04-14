package game.interactors.createplayer;

import game.entitiies.Player;
import game.repositories.PlayerRepositoryImpl;

import java.util.HashSet;
import java.util.Set;

class CreatePlayerRepositoryMock implements CreatePlayerGateway {
    private final Set<Player> players = new HashSet<>();
    boolean verifyCreateCalled = false;
    private int createCalledCounter = 0;
    boolean verifyCreateCalledEightTimes = false;
    boolean verifyPlayerLimitExceededCalled = false;

    @Override
    public boolean create(String token) {
        verifyCreateCalled = true;
        createCalledCounter++;
        verifyCreateCalledEightTimes = (createCalledCounter == 8);
        Player player = new Player(token);
        return players.add(player);
    }

    private int count() {
        return players.size();
    }

    @Override
    public boolean playerLimitExceeded() {
        verifyPlayerLimitExceededCalled = true;
        return count() < PlayerRepositoryImpl.PLAYER_LIMIT;
    }
}
