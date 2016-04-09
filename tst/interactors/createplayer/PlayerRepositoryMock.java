package interactors.createplayer;

import entitiies.Player;
import main.PlayerGateway;

public class PlayerRepositoryMock implements PlayerGateway {
    public boolean VerifySaveMethodCalled = false;
    public boolean VerifyCountMethodCalled = false;

    @Override
    public boolean save(Player player) {
        VerifySaveMethodCalled = true;
        return false;
    }

    @Override
    public int count() {
        VerifyCountMethodCalled = true;
        return 0;
    }
}
