package interactors.createplayer;

import entitiies.Player;
import main.PlayerGateway;

import java.util.HashSet;
import java.util.Set;

public class PlayerRepositoryMock extends PlayerGateway {
    private final Set<Player> players = new HashSet<>();
    public boolean VerifySaveMethodCalled = false;
    public boolean VerifyCountMethodCalled = false;

    @Override
    public boolean save(Player player) {
        VerifySaveMethodCalled = true;
        return players.add(player);
    }

    public int count() {
        VerifyCountMethodCalled = true;
        return players.size();
    }

}
