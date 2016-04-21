package game.entities;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TokenTest {

    @Test
    public void createToken() {
        Token token = new Token("Cat");
        assertTrue("Cat".equals(token.getDescription()));
    }
}
