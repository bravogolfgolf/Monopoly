package game.factories;

import game.entities.Token;

import java.util.Set;
import java.util.TreeSet;

class TokensTEST {

    static Set<Token> create() {
        return new TreeSet<Token>() {{
            add(new Token("One"));
            add(new Token("Two"));
            add(new Token("Three"));
            add(new Token("Four"));
            add(new Token("Five"));
            add(new Token("Six"));
            add(new Token("Seven"));
            add(new Token("Eight"));
            add(new Token("Nine"));
        }};    }
}