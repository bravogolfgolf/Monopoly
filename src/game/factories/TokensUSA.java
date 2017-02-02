package game.factories;

import game.entities.Token;

import java.util.Set;
import java.util.TreeSet;

public class TokensUSA {

    public static Set<Token> create() {
        return new TreeSet<Token>() {{
            add(new Token("Wheelbarrow"));
            add(new Token("Battleship"));
            add(new Token("Scottish Terrier"));
            add(new Token("Top Hat"));
            add(new Token("Cat"));
            add(new Token("Thimble"));
            add(new Token("Boot"));
            add(new Token("Automobile"));
        }};
    }
}
