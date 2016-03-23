package pkg.monopoly;

import pkg.board.GoToJail;
import pkg.board.Space;

import java.util.*;

public class Game {

    class InvalidPlayerCount extends Exception {

        InvalidPlayerCount(String message) {
            super(message);
        }

    }

    private static final int MINIMUM_NUMBER_OF_PLAYERS = 2;
    private static final int MAXIMUM_NUMBER_OF_PLAYERS = 8;
    private final List<Player> players = new ArrayList<>();
    private final Dice dice = new Dice();

    public void addPlayer(Player player) {
        players.add(player);
    }

    Player getPlayer(int index) {
        return players.get(index);
    }

    int getNumberOfPlayers() {
        return players.size();
    }

    void randomizePlayerOrder() {
        Collections.shuffle(players);
    }

    void start() throws InvalidPlayerCount {
        if (getNumberOfPlayers() < MINIMUM_NUMBER_OF_PLAYERS ||
                getNumberOfPlayers() > MAXIMUM_NUMBER_OF_PLAYERS)
            throw new InvalidPlayerCount(String.format("Number of Players: %d", getNumberOfPlayers()));
        randomizePlayerOrder();
        linkPlayers();
        play(dice);
    }

    private void linkPlayers() {
        for (int i = 0; i < players.size() - 1; i++) {
            players.get(i).setNextPlayer(players.get(i + 1));
        }
        players.get(players.size() - 1).setNextPlayer(players.get(0));
    }

    void play(Dice dice) {
        for (Player player : players) {
            Boolean managePropertiesAtEndOfTurn = true;
            try {
                player.takeATurn(dice);
            } catch (GoToJail.GoToJailException e) {
                Space space = player.getSpace();
                player.setSpace(space.searchForSpaceByDescription("Just Visiting/Jail"));
                player.setInJail(true);
                player.resetRollCounter();
                managePropertiesAtEndOfTurn = false;
            }
            if (managePropertiesAtEndOfTurn)
                player.manageProperties();
        }
    }
}
