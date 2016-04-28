package game.interactors;

import game.entities.Token;
import game.repositories.Players;

class PlayersMock extends Players {

    boolean verifyAddWithCalled = false;
    boolean verifyRandomizePlayersCalled = false;
    boolean verifyGetCurrentPlayerCalled = false;
    boolean verifyGetAllPlayersExceptCurrentCalled = false;

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
