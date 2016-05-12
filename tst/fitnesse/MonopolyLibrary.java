package game.fitnesse;

import game.Context;
import game.doubles.DiceRollThree;
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

    public void setCurrentPlayerSpaceToShortLine(){
        currentPlayer.move = 35;
        board.move(currentPlayer);
    }

    public void setCurrentPlayerSpaceToParkPlace(){
        currentPlayer.move = 37;
        board.move(currentPlayer);
    }

    public void setCurrentPlayerSpaceToBoardwalk(){
        currentPlayer.move = 39;
        board.move(currentPlayer);
    }

    public void currentPlayerRollsThree() {
        Context.dice = new DiceRollThree();
    }
}
