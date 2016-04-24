package game.entities;

import game.interactors.createplayer.CreatePlayerGateway;
import game.interactors.options.OptionsPlayerGateway;
import game.interactors.selectfirst.SelectFirstPlayerGateway;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Players implements CreatePlayerGateway, OptionsPlayerGateway, SelectFirstPlayerGateway {

    private final List<Token> players = new LinkedList<>();
    private final Set<Token> tokens;

    public Players(Set<Token> tokens) {
        this.tokens = tokens;
    }

    @Override
    public void create(Token token) {
        tokens.remove(token);
        players.add(token);
    }

    @Override
    public Token getPlayer(Token token) {
        if(players.contains(token))
            return token;
        throw new IllegalArgumentException();
    }

    @Override
    public Set<Token> getAvailableTokens() {
        return tokens;
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
