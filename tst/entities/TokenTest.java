package game.entities;

import game.repositories.PlayerRepositoryImpl;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TokenTest {

    @Test
    public void createToken() {
        PlayerRepositoryImpl.Player.Token token = new PlayerRepositoryImpl.Player.Token("Cat");
        assertTrue("Cat".equals(token.getDescription()));
    }
}
