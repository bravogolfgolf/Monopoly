package game.repositories;

import game.Context;
import game.entities.Token;
import game.interactors.partneroptions.PartnerOptionsGateway;
import game.interactors.selectfirst.SelectFirstPlayerGateway;
import game.interactors.tokenoptions.TokenOptionsPlayersGateway;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Players implements TokenOptionsPlayersGateway, SelectFirstPlayerGateway, PartnerOptionsGateway {

    private final List<Token> players = new LinkedList<>();

    @Override
    public void add(Token token) {
        players.add(token);
    }

    @Override
    public void randomizePlayers() {
        Collections.shuffle(players);
        Context.currentPlayer = players.get(0);
    }

    @Override
    public String[] getAllPlayersExceptCurrent() {
        List<Token> tokens = new LinkedList<>(players);
        tokens.remove(Context.currentPlayer);

        String[] result = new String[tokens.size()];

        int counter = 0;
        for (Token token : tokens) {
            result[counter++] = token.getDescription();
        }

        return result;
    }
}
