package pkg.card;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CardTest {

    private static final int NUMBER_OF_CARDS_IN_DECK = 4;
    private static final int BOTTOM_CARD = 3;

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCard1() {
        CardFactory.create("Invalid", "Invalid");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCard2() {
        CardFactory.create("Invalid", "Invalid", "Invalid");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCard3() {
        CardFactory.create("Invalid", "Invalid", 1, "Invalid");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCard4() {
        CardFactory.create("Invalid", "Invalid", 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoadCardException() throws IOException {
        CardFactory.load("Card_EXCEPTION.txt");
    }

    @Test
    public void testCardIsGetOutOfJailCard() {
        Card card = CardFactory.create("Instruction", "GetOutOfJail");
        assertTrue(card.isGetOutOfJailCard());
        card = CardFactory.create("Text", "MoveBack");
        assertFalse(card.isGetOutOfJailCard());
        card = CardFactory.create("Text", "MoveForwardNext", "Text");
        assertFalse(card.isGetOutOfJailCard());
        card = CardFactory.create("Text", "MoveForwardSpecific", "Text");
        assertFalse(card.isGetOutOfJailCard());
        card = CardFactory.create("Text", "MoveJail", "Text");
        assertFalse(card.isGetOutOfJailCard());
        card = CardFactory.create("Text", "Repairs", 0, 0);
        assertFalse(card.isGetOutOfJailCard());
        card = CardFactory.create("Text", "Transaction", 0, "Text");
        assertFalse(card.isGetOutOfJailCard());
    }

    @Test
    public void testChestCardsAreNotAlwaysInSameOrder() throws IOException {

        boolean oneTwo = false;
        boolean twoOne = false;

        for (int i = 0; i < 100; i++) {
            Deck.clearCards();
            List<Card> CommunityChestCards = Deck.getCommunityChestCards();
            assertEquals(0, CommunityChestCards.size());

            List<Card> mimicOutputFromCardLoadMethod = new ArrayList<>();
            Card card1 = CardFactory.create("Instruction1", "MoveForwardSpecific", "Go");
            Card card2 = CardFactory.create("Instruction2", "Transaction", 100, "Bank");

            mimicOutputFromCardLoadMethod.add(card1);
            mimicOutputFromCardLoadMethod.add(card2);

            Deck.addCommunityChestCards(mimicOutputFromCardLoadMethod);
            Deck.randomizeCardOrder();
            CommunityChestCards = Deck.getCommunityChestCards();
            assertEquals(2, CommunityChestCards.size());

            if (CommunityChestCards.get(0).equals(card1) && CommunityChestCards.get(1).equals(card2))
                oneTwo = true;

            if (CommunityChestCards.get(0).equals(card2) && CommunityChestCards.get(1).equals(card1))
                twoOne = true;

            if (oneTwo && twoOne)
                break;
        }
        assertTrue(oneTwo && twoOne);
    }

    @Test
    public void testDrawCommunityChestCard() throws IOException {

        List<Card> communityChestCards = CardFactory.load("Chest_TEST.txt");
        Deck.addCommunityChestCards(communityChestCards);

        Card expectedTopCard = CardFactory.create("Instruction1", "MoveForwardSpecific", "Go");
        Card topCard = Deck.drawCard("Community Chest");
        Card expectedBottomCard = Deck.getCommunityChestCards().get(BOTTOM_CARD);

        assertEquals(NUMBER_OF_CARDS_IN_DECK, Deck.getCommunityChestCards().size());
        assertTrue(expectedTopCard.equals(topCard));
        assertTrue(topCard.equals(expectedBottomCard));
    }

    @Test
    public void testDrawChanceCard() throws IOException {
        List<Card> chanceCards = CardFactory.load("Chance_TEST.txt");
        Deck.addChanceCards(chanceCards);

        Card expectedTopCard = CardFactory.create("Instruction1", "MoveForwardSpecific", "Go");
        Card topCard = Deck.drawCard("Chance");
        Card expectedBottomCard = Deck.getChanceCards().get(BOTTOM_CARD);

        assertEquals(NUMBER_OF_CARDS_IN_DECK, Deck.getChanceCards().size());
        assertTrue(expectedTopCard.equals(topCard));
        assertTrue(topCard.equals(expectedBottomCard));
    }

    @Test
    public void testChanceCardsAreNotAlwaysInSameOrder() throws IOException {

        boolean oneTwo = false;
        boolean twoOne = false;

        for (int i = 0; i < 100; i++) {
            Deck.clearCards();
            List<Card> ChanceCards = Deck.getChanceCards();
            assertEquals(0, ChanceCards.size());

            List<Card> mimicOutputFromCardLoadMethod = new ArrayList<>();
            Card card1 = CardFactory.create("Instruction1", "MoveForwardSpecific", "Go");
            Card card2 = CardFactory.create("Instruction2", "Transaction", 100, "Bank");

            mimicOutputFromCardLoadMethod.add(card1);
            mimicOutputFromCardLoadMethod.add(card2);

            Deck.addChanceCards(mimicOutputFromCardLoadMethod);
            Deck.randomizeCardOrder();
            ChanceCards = Deck.getChanceCards();
            assertEquals(2, ChanceCards.size());

            if (ChanceCards.get(0).equals(card1) && ChanceCards.get(1).equals(card2))
                oneTwo = true;

            if (ChanceCards.get(0).equals(card2) && ChanceCards.get(1).equals(card1))
                twoOne = true;

            if (oneTwo && twoOne)
                break;
        }
        assertTrue(oneTwo && twoOne);
    }

    @Test
    public void testReadOfCardDefinitionFile() throws IOException {
        final String filename = "Chest_TEST.txt";
        List<Card> expected = new ArrayList<>();
        List<Card> actual;
        expected.add(CardFactory.create("Instruction1", "MoveForwardSpecific", "Go"));
        expected.add(CardFactory.create("Instruction2", "Transaction", 100, "Bank"));
        expected.add(CardFactory.create("Instruction2", "GetOutOfJail"));
        expected.add(CardFactory.create("Instruction2", "Repairs", 40, 115));
        actual = CardFactory.load(filename);
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.equals(actual));
        for (int index = 0; index < expected.size(); index++) {
            assertTrue(expected.get(index).equals(actual.get(index)));
        }
    }

    @Test
    public void testHashcode() {
        MoveForwardSpecific move1 = (MoveForwardSpecific) CardFactory.create("Instruction1", "MoveForwardSpecific", "Go");
        MoveForwardSpecific move2 = (MoveForwardSpecific) CardFactory.create("Instruction1", "MoveForwardSpecific", "Go");
        assertEquals(move1.hashCode(), move2.hashCode());
    }
}
