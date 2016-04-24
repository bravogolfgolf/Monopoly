package game.entities;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertTrue;

public class PlayersTest {

    private Players playerRepository;

    @Before
    public void setUp() {
        Set<Token> tokens = new TreeSet<Token>() {{
            add(new Token("Cat"));
            add(new Token("Boot"));
        }};
        playerRepository = new Players(tokens);
    }

    @Test
    public void testCreatePlayer() {
        Set<Token> tokens = playerRepository.getAvailableTokens();
        assertTrue(tokens.size() == 2);

        playerRepository.create(new Token("Cat"));

        tokens = playerRepository.getAvailableTokens();
        assertTrue(tokens.size() == 1);
    }

    @Test
    public void testPlayersAreNotAlwaysInSameStartingOrder() {
        int count = 0;

        for (int i = 0; i < 100; i++) {

            Set<Token> treeSet = new TreeSet<Token>() {{
                add(new Token("Cat"));
                add(new Token("Boot"));
            }};
            playerRepository = new Players(treeSet);

            playerRepository.create(new Token("Cat"));
            playerRepository.create(new Token("Boot"));

            playerRepository.randomizePlayers();

            if (playerRepository.getNextPlayer().getDescription().equals("Cat"))
                count++;
        }
        assertTrue(count > 0);
    }
}