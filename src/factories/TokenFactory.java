package game.factories;

import game.entities.Players;

import java.util.Set;
import java.util.TreeSet;

class TokenFactory {

    static Set<Players.Player.Token> tokenSet(String version) {
        Set<Players.Player.Token> tokens = new TreeSet<>();
        String[] tokenDescriptions = new String[0];

        String[] tokensUSA = new String[]{"Wheelbarrow", "Battleship", "Scottish Terrier", "Top Hat", "Cat", "Thimble", "Boot", "Automobile"};
        String[] tokensTEST = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

        if (version.equals("USA"))
            tokenDescriptions = tokensUSA;
        if (version.equals("TEST"))
            tokenDescriptions = tokensTEST;

        makeSet(tokens, tokenDescriptions);
        return tokens;
    }

    private static void makeSet(Set<Players.Player.Token> tokens, String[] tokenDescriptions) {
        for (String token : tokenDescriptions) {
            tokens.add(new Players.Player.Token(token));
        }
    }
}
