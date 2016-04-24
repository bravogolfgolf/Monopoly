package game.entities;

import game.interactors.createplayer.CreatePlayerGateway;
import game.interactors.selectfirst.SelectFirstPlayerGateway;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Players implements CreatePlayerGateway, SelectFirstPlayerGateway {

    private final List<Token> players = new LinkedList<>();

    @Override
    public void create(Token token) {
        players.add(token);
    }

    @Override
    public Token getPlayer(Token token) {
        if (players.contains(token))
            return token;
        throw new IllegalArgumentException();
    }

    @Override
    public void randomizePlayers() {
        Collections.shuffle(players);
    }

    @Override
    public Token getNextPlayer() {
        return players.get(0);
    }

}
