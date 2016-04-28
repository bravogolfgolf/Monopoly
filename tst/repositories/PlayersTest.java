package game.repositories;

import game.entities.Token;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class PlayersTest {

    private final Players playerRepository = new Players();

    @Test
    public void testCreatePlayer() {
        Token token = new Token("Cat");
        playerRepository.addWith(token);
        playerRepository.randomizePlayers();
        assertTrue(playerRepository.getCurrentPlayer().equals(token));
    }

    @Test
    public void testPlayersAreNotAlwaysInSameStartingOrder() {
        int count = 0;

        for (int i = 0; i < 100; i++) {

            playerRepository.addWith(new Token("Cat"));
            playerRepository.addWith(new Token("Boot"));

            playerRepository.randomizePlayers();

            if (playerRepository.getCurrentPlayer().getDescription().equals("Cat"))
                count++;
        }
        assertTrue(count > 0);
    }

    @Test
    public void testGetAllPlayersExceptCurrent() {
        Token token = new Token("Cat");
        playerRepository.addWith(token);
        playerRepository.randomizePlayers();

        token = new Token("Boot");
        playerRepository.addWith(token);
        token = new Token("Thimble");
        playerRepository.addWith(token);

        String[] expected = new String[]{"Boot", "Thimble"};
        assertArrayEquals(expected, playerRepository.getAllPlayersExceptCurrent());
    }
}