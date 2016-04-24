package game.interactors;

import game.entities.Players;
import game.entities.Token;

class PlayersMock extends Players {

    boolean verifyCreateCalled = false;
    boolean verifyRandomizePlayers = false;
    boolean verifyGetFirstPlayer = false;
    boolean verifyGetPlayerCalled = false;

    @Override
    public void create(Token request) {
        verifyCreateCalled = true;
    }

    @Override
    public Token getPlayer(Token request) {
        verifyGetPlayerCalled = true;
        return null;
    }

    @Override
    public void randomizePlayers() {
        verifyRandomizePlayers = true;
    }

    @Override
    public Token getNextPlayer() {
        verifyGetFirstPlayer = true;
        return new Token("Cat");
    }
}
