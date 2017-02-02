package game.fitnesse;

import game.doubles.*;
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

    public void setCurrentPlayerSpaceToBORailroad(){
        currentPlayer.setMove(25);
        board.move(currentPlayer);
    }

    public void setCurrentPlayerSpaceToShortLine(){
        currentPlayer.setMove(35);
        board.move(currentPlayer);
    }

    public void setCurrentPlayerSpaceToParkPlace(){
        currentPlayer.setMove(37);
        board.move(currentPlayer);
    }

    public void setCurrentPlayerSpaceToBoardwalk(){
        currentPlayer.setMove(39);
        board.move(currentPlayer);
    }

    public void currentPlayerRollsTwo() {
        dice = new DiceRollTwo();
    }

    public void currentPlayerRollsThree() {
        dice = new DiceRollThree();
    }

    public void currentPlayerRollsFour() {
        dice = new DiceRollFour();
    }

    public void currentPlayerRollsFive() {
        dice = new DiceRollFive();
    }

    public void currentPlayerRollsSeven() {
        dice = new DiceRollSeven();
    }

    public void currentPlayerRollsTen() {
        dice = new DiceRollTen();
    }
}
