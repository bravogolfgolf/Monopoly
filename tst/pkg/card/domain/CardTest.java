package pkg.card.domain;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CardTest {

    private static final int NUMBER_OF_CARDS_IN_DECK = 3;
    private static final int BOTTOM_CARD = 2;

    @Before
    public void setUp() throws Exception {
        Deck.create(new DeckFactoryFakeTEST(), Deck.DeckType.CHEST, "TEST");
        Deck.create(new DeckFactoryFakeTEST(), Deck.DeckType.CHANCE, "TEST");
    }

    @Test
    public void testCardIsGetOutOfJailCard() {
        Card card;
        card = new GetOutOfJail("");
        assertTrue(card.isGetOutOfJailCard());
        card = new MoveBack("");
        assertFalse(card.isGetOutOfJailCard());
        card = new MoveForwardNext("", "");
        assertFalse(card.isGetOutOfJailCard());
        card = new MoveForwardSpecific("", "");
        assertFalse(card.isGetOutOfJailCard());
        card = new MoveJail("", "");
        assertFalse(card.isGetOutOfJailCard());
        card = new Repair("", 0, 0);
        assertFalse(card.isGetOutOfJailCard());
        card = new Transaction("", 0, "");
        assertFalse(card.isGetOutOfJailCard());
    }

    @Test
    public void testDrawCommunityChestCard() throws IOException {
        Card topCard = Deck.drawCard(Deck.DeckType.CHEST);
        Card bottomCard = Deck.getCommunityChestCards().get(BOTTOM_CARD);

        assertEquals(NUMBER_OF_CARDS_IN_DECK, Deck.getCommunityChestCards().size());
        assertTrue(topCard.equals(bottomCard));
    }

    @Test
    public void testDrawChanceCard() throws IOException {
        Card topCard = Deck.drawCard(Deck.DeckType.CHANCE);
        Card expectedBottomCard = Deck.getChanceCards().get(BOTTOM_CARD);

        assertEquals(NUMBER_OF_CARDS_IN_DECK, Deck.getChanceCards().size());
        assertTrue(topCard.equals(expectedBottomCard));
    }


    @Test
    public void testHashcode() {
        Card move1 = new MoveForwardSpecific("Instruction1", "Go");
        Card move2 = new MoveForwardSpecific("Instruction1", "Go");
        assertEquals(move1.hashCode(), move2.hashCode());
    }
}
