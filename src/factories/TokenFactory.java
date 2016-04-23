package game.factories;

import game.entities.Players;

import java.util.Set;
import java.util.TreeSet;

class TokenFactory {

    private static final Set<Players.Player.Token> tokens = new TreeSet<>();
    private static String[] tokenDescriptions = new String[0];

    static Set<Players.Player.Token> tokenSet(String version) {

        if (version.equals("USA"))
            tokenDescriptions = new String[]{"Wheelbarrow", "Battleship", "Scottish Terrier", "Top Hat", "Cat", "Thimble", "Boot", "Automobile"};

        if (version.equals("TEST"))
            tokenDescriptions = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

        for (String token : tokenDescriptions)
            tokens.add(new Players.Player.Token(token));

        return tokens;
    }

}
