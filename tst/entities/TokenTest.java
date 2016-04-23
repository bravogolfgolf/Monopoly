package game.entities;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TokenTest {

    @Test
    public void createToken() {
        Players.Player.Token token = new Players.Player.Token("Cat");
        assertTrue("Cat".equals(token.getDescription()));
    }
}
