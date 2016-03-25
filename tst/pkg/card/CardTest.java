package pkg.card;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CardTest {

    private static final int NUMBER_OF_CARDS_IN_DECK = 3;
    private static final int BOTTOM_CARD = 2;

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCard1() {
        DeckFactory.create("Invalid", "Invalid");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCard2() {
        DeckFactory.create("Invalid", "Invalid", "Invalid");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCard3() {
        DeckFactory.create("Invalid", "Invalid", 1, "Invalid");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCard4() {
        DeckFactory.create("Invalid", "Invalid", 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoadCardException() throws IOException {
        DeckFactory.load(DeckFactory.DeckType.CHEST, "EXCEPTION");
    }

    @Test
    public void testCardIsGetOutOfJailCard() {
        Card card = DeckFactory.create("Instruction", "GetOutOfJail");
        assertTrue(card.isGetOutOfJailCard());
        card = DeckFactory.create("Text", "MoveBack");
        assertFalse(card.isGetOutOfJailCard());
        card = DeckFactory.create("Text", "MoveForwardNext", "Text");
        assertFalse(card.isGetOutOfJailCard());
        card = DeckFactory.create("Text", "MoveForwardSpecific", "Text");
        assertFalse(card.isGetOutOfJailCard());
        card = DeckFactory.create("Text", "MoveJail", "Text");
        assertFalse(card.isGetOutOfJailCard());
        card = DeckFactory.create("Text", "Repairs", 0, 0);
        assertFalse(card.isGetOutOfJailCard());
        card = DeckFactory.create("Text", "Transaction", 0, "Text");
        assertFalse(card.isGetOutOfJailCard());
    }


    @Test
    public void testDrawCommunityChestCard() throws IOException {
        List<Card> communityChestCards = DeckFactory.load(DeckFactory.DeckType.CHEST, "TEST");
        Deck.addCommunityChestCards(communityChestCards);

        Card topCard = Deck.drawCard(DeckFactory.DeckType.CHEST);
        Card bottomCard = Deck.getCommunityChestCards().get(BOTTOM_CARD);

        assertEquals(NUMBER_OF_CARDS_IN_DECK, Deck.getCommunityChestCards().size());
        assertTrue(topCard.equals(bottomCard));
    }

    @Test
    public void testDrawChanceCard() throws IOException {
        List<Card> chanceCards = DeckFactory.load(DeckFactory.DeckType.CHANCE, "TEST");
        Deck.addChanceCards(chanceCards);

        Card topCard = Deck.drawCard(DeckFactory.DeckType.CHANCE);
        Card expectedBottomCard = Deck.getChanceCards().get(BOTTOM_CARD);

        assertEquals(NUMBER_OF_CARDS_IN_DECK, Deck.getChanceCards().size());
        assertTrue(topCard.equals(expectedBottomCard));
    }


    @Test
    public void testReadOfCardDefinitionFile() throws IOException {
        List<Card> expected = new ArrayList<>();
        List<Card> actual;
        expected.add(DeckFactory.create("Instruction1", "MoveForwardSpecific", "Go"));
        expected.add(DeckFactory.create("Instruction2", "Transaction", 100, "Bank"));
        expected.add(DeckFactory.create("Instruction2", "Repairs", 40, 115));
        actual = DeckFactory.load(DeckFactory.DeckType.CHEST, "TEST");
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.equals(actual));
        for (int index = 0; index < expected.size(); index++) {
            assertTrue(expected.get(index).equals(actual.get(index)));
        }
    }

    @Test
    public void testHashcode() {
        MoveForwardSpecific move1 = (MoveForwardSpecific) DeckFactory.create("Instruction1", "MoveForwardSpecific", "Go");
        MoveForwardSpecific move2 = (MoveForwardSpecific) DeckFactory.create("Instruction1", "MoveForwardSpecific", "Go");
        assertEquals(move1.hashCode(), move2.hashCode());
    }
}
