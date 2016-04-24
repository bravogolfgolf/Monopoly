package game.entities;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlayersTest {

    private final Players playerRepository = new Players();

    @Test
    public void testCreatePlayer() {
        Token token = new Token("Cat");
        playerRepository.addWith(token);
        assertTrue(playerRepository.getNextPlayer().equals(token));
    }

    @Test
    public void testPlayersAreNotAlwaysInSameStartingOrder() {
        int count = 0;

        for (int i = 0; i < 100; i++) {

            playerRepository.addWith(new Token("Cat"));
            playerRepository.addWith(new Token("Boot"));

            playerRepository.randomizePlayers();

            if (playerRepository.getNextPlayer().getDescription().equals("Cat"))
                count++;
        }
        assertTrue(count > 0);
    }
}