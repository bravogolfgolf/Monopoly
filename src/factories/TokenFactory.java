package game.factories;

import game.repositories.PlayerRepositoryImpl;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

class TokenFactory {

    static Set<PlayerRepositoryImpl.Player.Token> tokenSet(String version) {
        Set<PlayerRepositoryImpl.Player.Token> tokens = new LinkedHashSet<>();
        String[] tokenDescriptions = new String[0];

        String[] tokensUSA = new String[]{"Wheelbarrow", "Battleship", "Scottish Terrier", "Top Hat", "Cat", "Thimble", "Boot", "Automobile"};
        String[] tokensTEST = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

        if (version.equals("USA"))
            tokenDescriptions = tokensUSA;
        if (version.equals("TEST"))
            tokenDescriptions = tokensTEST;

        Arrays.sort(tokenDescriptions);
        makeSet(tokens, tokenDescriptions);
        return tokens;
    }

    private static void makeSet(Set<PlayerRepositoryImpl.Player.Token> tokens, String[] tokenDescriptions) {
        for (String token : tokenDescriptions) {
            tokens.add(new PlayerRepositoryImpl.Player.Token(token));
        }
    }
}
