package pkg.board.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pkg.card.domain.Card;
import pkg.card.domain.Deck;
import pkg.card.domain.GetOutOfJail;
import pkg.game.OwnershipMultiplier;
import pkg.game.Player;
import pkg.game.SourceOfMoveMultiplier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommunityChestTest {

    private Player player;
    private CommunityChest communityChest;
    private List<Card> cards;
    private GetOutOfJail card;
    private int expectedEndingBalance;

    @Before
    public void setUp() {
        player = new Player("Cat");
        communityChest = new CommunityChest("Community Chest");
        cards = new ArrayList<>();
        card = new GetOutOfJail("Get out of Jail Free – This card may be kept until needed or sold");
        cards.add(card);
        Deck.addCommunityChestCards(cards);
        expectedEndingBalance = player.getCashBalance();
    }

    @After
    public void teardown() {
        player = null;
        communityChest = null;
        cards = null;
        card = null;
    }

    @Test
    public void testLandOn() {
        communityChest.landOn(player, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        assertEquals(expectedEndingBalance, player.getCashBalance());
        assertTrue(player.getCard().equals(card));
    }

    @Test
    public void testPassBy() {
        communityChest.passBy(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }
}
