package game.repositories;

import game.Context;
import game.entities.Token;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class PlayersTest {

    private final Players playerRepository = new Players();
    private final Token cat = new Token("Cat");
    private final Token boot = new Token("Boot");
    private final Token thimble = new Token("Thimble");

    @Test
    public void testAddPlayer() {
        playerRepository.add(cat);
        playerRepository.randomizePlayers();
        assertTrue(Context.currentPlayer.equals(cat));
    }

    @Test
    public void testPlayersAreNotAlwaysInSameStartingOrder() {
        int count = 0;

        for (int i = 0; i < 100; i++) {

            playerRepository.add(cat);
            playerRepository.add(boot);

            playerRepository.randomizePlayers();

            if (Context.currentPlayer.getDescription().equals("Cat"))
                count++;
        }
        assertTrue(count > 0);
    }

    @Test
    public void testGetAllPlayersExceptCurrent() {
        playerRepository.add(cat);
        playerRepository.randomizePlayers();

        playerRepository.add(boot);
        playerRepository.add(thimble);

        String[] expected = new String[]{"Boot", "Thimble"};
        assertArrayEquals(expected, playerRepository.getAllPlayersExceptCurrent());
    }
}