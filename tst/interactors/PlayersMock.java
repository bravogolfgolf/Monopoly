package game.interactors;

import game.entities.Players;
import game.entities.Token;

class PlayersMock extends Players {

    boolean verifyCreateCalled = false;
    boolean verifyRandomizePlayers = false;
    boolean verifyGetFirstPlayer = false;

    @Override
    public void addWith(Token request) {
        verifyCreateCalled = true;
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
