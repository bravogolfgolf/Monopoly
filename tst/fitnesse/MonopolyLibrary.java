package game.fitnesse;

import game.Context;
import game.entities.Board;
import game.entities.Token;
import game.factories.SpacesUSA;
import game.factories.TokensUSA;
import game.manager.StateImpl;
import game.repositories.Tokens;

import java.io.IOException;

public class MonopolyLibrary {

    public MonopolyLibrary() {
    }

    public boolean startNewGame() throws IOException {
        Setup.monopoly.setup(StateImpl.VERSION);
        return true;
    }

    public boolean createVersionOfGame() throws IOException {
        Context.board = Board.create(SpacesUSA.create());
        Context.tokens = new Tokens(TokensUSA.create());
        return true;
    }

    public boolean addTwoPlayersToGame() throws IOException {
        Token token = new Token("Cat");
        token.setSpace(Context.board.findSpaceBy(token.spaceID));
        Context.players.add(token);
        token = new Token("Boot");
        token.setSpace(Context.board.findSpaceBy(token.spaceID));
        Context.players.add(token);
        Context.players.randomizePlayers();
        return true;
    }
}
