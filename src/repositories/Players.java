package game.repositories;

import game.entities.Token;
import game.interactors.movetoken.MoveTokenPlayerGateway;
import game.interactors.partneroptions.PartnerOptionsGateway;
import game.interactors.propertyoptions.PropertyOptionsPlayerGateway;
import game.interactors.selectfirst.SelectFirstPlayerGateway;
import game.interactors.tokenoptions.TokenOptionsPlayersGateway;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Players implements TokenOptionsPlayersGateway, SelectFirstPlayerGateway, PropertyOptionsPlayerGateway,
        PartnerOptionsGateway, MoveTokenPlayerGateway {

    private final List<Token> players = new LinkedList<>();
    private Token current;

    @Override
    public void add(Token token) {
        players.add(token);
    }

    @Override
    public void randomizePlayers() {
        Collections.shuffle(players);
        current = players.get(0);
    }

    @Override
    public Token getCurrentPlayer() {
        return current;
    }

    @Override
    public String[] getAllPlayersExceptCurrent() {
        List<Token> tokens = new LinkedList<>(players);
        tokens.remove(current);

        String[] result = new String[tokens.size()];

        int counter = 0;
        for (Token token : tokens) {
            result[counter++] = token.getDescription();
        }

        return result;
    }
}
