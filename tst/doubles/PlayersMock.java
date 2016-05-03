package game.doubles;

import game.Context;
import game.entities.Token;
import game.repositories.Players;

public class PlayersMock extends Players {

    public boolean verifyAddWithCalled = false;
    public boolean verifyRandomizePlayersCalled = false;
    public boolean verifyGetAllPlayersExceptCurrentCalled = false;

    @Override
    public void add(Token request) {
        verifyAddWithCalled = true;
    }

    @Override
    public void randomizePlayers() {
        verifyRandomizePlayersCalled = true;
        Context.currentPlayer = new Token("Cat");
    }

    @Override
    public String[] getAllPlayersExceptCurrent() {
        verifyGetAllPlayersExceptCurrentCalled = true;
        return new String[0];
    }
}
