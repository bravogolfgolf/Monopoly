package game.interactors;

import game.entities.Token;
import game.interactors.createplayer.CreatePlayerGateway;
import game.interactors.options.OptionsPlayerGateway;
import game.interactors.selectfirst.SelectFirstPlayerGateway;

import java.util.Set;
import java.util.TreeSet;

class PlayersMock implements CreatePlayerGateway, OptionsPlayerGateway, SelectFirstPlayerGateway {

    boolean verifyCreateCalled = false;
    boolean verifyGetAvailableTokens = false;
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
    public Set<Token> getAvailableTokens() {
        verifyGetAvailableTokens = true;
        return new TreeSet<Token>() {{
            new Token("Cat");
        }};
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
