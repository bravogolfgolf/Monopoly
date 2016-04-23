package game.entities;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class PlayersTest {

    private Players playerRepository;

    @Before
    public void setUp() {
        Set<Players.Player.Token> tokens = new LinkedHashSet<>(Collections.singletonList(new Players.Player.Token("Cat")));
        playerRepository = new Players(tokens);
    }

    @Test
    public void testCreatePlayer() {
        String[] tokens = playerRepository.getAvailableTokens();
        assertTrue(tokens.length == 1);

        playerRepository.create("Cat");

        tokens = playerRepository.getAvailableTokens();
        assertTrue(tokens.length == 0);
    }
}