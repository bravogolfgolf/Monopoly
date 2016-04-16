package game.repositories;

import game.entitiies.Token;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class PlayerRepositoryImplTest {

    private PlayerRepositoryImpl playerRepository;

    @Before
    public void setUp() {
        List<Token> tokens = new ArrayList<>(Collections.singletonList(new Token("Cat")));
        playerRepository = new PlayerRepositoryImpl(tokens);
    }

    @Test
    public void testCreatePlayer() {
        playerRepository.create("Cat");
        assertTrue(playerRepository.count() == 1);
        assertTrue(!playerRepository.isAvailable("Cat"));
    }

    @Test
    public void testGetTokens() {
        String[] tokens = playerRepository.getAvailableTokens();
        assertTrue(tokens.length == 1);
    }
}