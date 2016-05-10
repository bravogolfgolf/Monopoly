package game.fitnesse;

import game.entities.Board;
import game.entities.Token;
import game.factories.SpacesUSA;
import game.factories.TokensUSA;
import game.manager.StateImpl;
import game.repositories.Tokens;

import java.io.IOException;

import static game.Context.*;

public class MonopolyLibrary {

    public MonopolyLibrary() {
    }

    public boolean startNewGame() throws IOException {
        Setup.monopoly.setup(StateImpl.VERSION);
        return true;
    }

    public boolean createVersionOfGame() throws IOException {
        board = Board.create(SpacesUSA.create());
        tokens = new Tokens(TokensUSA.create());
        return true;
    }

    public boolean addTwoPlayersToGame() throws IOException {
        Token token = tokens.createToken("Cat");
        board.setInitialSpace(token);
        players.add(token);
        token = tokens.createToken("Boot");
        board.setInitialSpace(token);
        players.add(token);
        players.randomizePlayers();
        return true;
    }
}
