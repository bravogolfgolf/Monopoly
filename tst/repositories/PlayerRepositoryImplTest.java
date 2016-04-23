package game.repositories;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class PlayerRepositoryImplTest {

    private PlayerRepositoryImpl playerRepository;

    @Before
    public void setUp() {
        Set<PlayerRepositoryImpl.Player.Token> tokens = new LinkedHashSet<>(Collections.singletonList(new PlayerRepositoryImpl.Player.Token("Cat")));
        playerRepository = new PlayerRepositoryImpl(tokens);
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