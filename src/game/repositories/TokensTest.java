package game.repositories;

import game.entities.Token;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class TokensTest {

    private Token token;
    private Set<Token> tokensSet;
    private Tokens tokens;

    @Before
    public void setUp() {
        token = new Token("Cat");
        tokensSet = new TreeSet<Token>() {{
            add(token);
        }};
        tokens = new Tokens(tokensSet);
    }

    @Test
    public void testGetAvailableTokens() {
        assertEquals(tokensSet, tokens.getAvailableTokens());
    }

    @Test
    public void testRemoveToken() {
        Set<Token> expected = new TreeSet<>();
        tokens.createToken("Cat");
        assertEquals(expected, tokens.getAvailableTokens());
    }
}
