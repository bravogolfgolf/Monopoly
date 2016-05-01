package game.doubles;

import game.entities.Token;
import game.repositories.Players;

public class PlayersMock extends Players {

    public boolean verifyAddWithCalled = false;
    public boolean verifyRandomizePlayersCalled = false;
    public boolean verifyGetCurrentPlayerCalled = false;
    public boolean verifyGetAllPlayersExceptCurrentCalled = false;

    @Override
    public void addWith(Token request) {
        verifyAddWithCalled = true;
    }

    @Override
    public void randomizePlayers() {
        verifyRandomizePlayersCalled = true;
    }

    @Override
    public Token getCurrentPlayer() {
        verifyGetCurrentPlayerCalled = true;
        return new Token("Cat");
    }

    @Override
    public String[] getAllPlayersExceptCurrent() {
        verifyGetAllPlayersExceptCurrentCalled = true;
        return new String[0];
    }
}
