package game.entities;

import game.interactors.createplayer.CreatePlayerTokensGateway;
import game.interactors.options.OptionsTokensGateway;

import java.util.Set;
import java.util.TreeSet;

public class Tokens implements OptionsTokensGateway, CreatePlayerTokensGateway {

    private final Set<Token> tokens;

    private Tokens(Set<Token> tokens) {
        this.tokens = tokens;
    }

    public static Tokens create(String version) {
        Set<Token> tokens = new TreeSet<>();
        String[] tokenDescriptions = new String[0];

        if (version.equals("USA"))
            tokenDescriptions = new String[]{"Wheelbarrow", "Battleship", "Scottish Terrier", "Top Hat", "Cat", "Thimble", "Boot", "Automobile"};

        if (version.equals("TEST"))
            tokenDescriptions = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

        for (String token : tokenDescriptions)
            tokens.add(new Token(token));

        return new Tokens(tokens);
    }

    @Override
    public Set<Token> getAvailableTokens() {
        return tokens;
    }

    @Override
    public void removeToken(Token token) {
        tokens.remove(token);
    }
}
