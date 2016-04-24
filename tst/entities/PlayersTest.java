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
        Set<Players.Player.Token> tokens = new TreeSet<Players.Player.Token>() {{
            add(new Players.Player.Token("Cat"));
            add(new Players.Player.Token("Boot"));
        }};
        playerRepository = new Players(tokens);
    }

    @Test
    public void testCreatePlayer() {
        String[] tokens = playerRepository.getAvailableTokens();
        assertTrue(tokens.length == 2);

        playerRepository.create("Cat");

        tokens = playerRepository.getAvailableTokens();
        assertTrue(tokens.length == 1);
    }

    @Test
    public void testPlayersAreNotAlwaysInSameStartingOrder() {
        int count = 0;

        for (int i = 0; i < 100; i++) {

            Set<Players.Player.Token> treeSet = new TreeSet<Players.Player.Token>() {{
                add(new Players.Player.Token("Cat"));
                add(new Players.Player.Token("Boot"));
            }};
            playerRepository = new Players(treeSet);

            playerRepository.create("Cat");
            playerRepository.create("Boot");

            playerRepository.randomizePlayers();

            if (playerRepository.getFirstPlayer().equals("Cat"))
                count++;
        }
        assertTrue(count > 0);
    }
}