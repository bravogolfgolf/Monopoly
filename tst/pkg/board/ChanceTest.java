package pkg.board;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pkg.board.Chance;
import pkg.board.Space;
import pkg.card.*;
import pkg.monopoly.OwnershipMultiplier;
import pkg.monopoly.Player;
import pkg.monopoly.SourceOfMoveMultiplier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChanceTest {

    private Player player;
    private Chance chance;

    @Before
    public void setUp() {
        player = new Player("Cat");
        chance = (Chance) Space.create("Chance", "Chance");
    }

    @After
    public void teardown() {
        player = null;
        chance = null;
    }

    @Test
    public void testLandOn()  {
        List<Card> cards = new ArrayList<>();
        Deck.clearCards();
        Card card = DeckFactory.create("Instruction", "GetOutOfJail");
        cards.add(card);
        Deck.addChanceCards(cards);
        int expectedEndingBalance = player.getCashBalance();
        chance.landOn(player, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        assertEquals(expectedEndingBalance, player.getCashBalance());
        assertTrue(player.getCard().equals(card));
    }

    @Test
    public void testPassBy() {
        List<Card> cards = new ArrayList<>();
        Deck.clearCards();
        Card card = DeckFactory.create("Instruction", "GetOutOfJail");
        cards.add(card);
        Deck.addChanceCards(cards);
        int expectedEndingBalance = player.getCashBalance();
        chance.passBy(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }
}
