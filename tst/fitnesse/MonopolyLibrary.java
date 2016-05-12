package game.fitnesse;

import game.Context;
import game.doubles.DicePassGo;
import game.entities.Token;
import game.factories.VersionFactory;
import game.manager.StateImpl;

import java.io.IOException;

import static game.Context.*;

public class MonopolyLibrary {

    public MonopolyLibrary() {
    }

    public void startNewGame() throws IOException {
        Setup.monopoly.setup(StateImpl.VERSION);
    }

    public void createVersionOfGame() throws IOException {
        VersionFactory factory = new VersionFactory();
        factory.make("USA");
    }

    public void addTwoPlayersToGame() throws IOException {
        Token token = tokens.createToken("Cat");
        board.setInitialSpace(token);
        players.add(token);
        token = tokens.createToken("Boot");
        board.setInitialSpace(token);
        players.add(token);
        players.randomizePlayers();
    }

    public void rollPlayerPassedGo() {
        Context.dice = new DicePassGo();
    }
}
