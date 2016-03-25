package pkg.card.domain;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeckTest {

    @Test
    public void testCommunityChestAndChanceCardsCreated() throws IOException {
        Deck.create(new DeckFactoryFakeUS(), Deck.DeckType.CHEST,"US");
        Deck.create(new DeckFactoryFakeUS(), Deck.DeckType.CHANCE,"US");
        assertEquals(17, Deck.getCommunityChestCards().size());
        assertEquals(15, Deck.getChanceCards().size());
    }

    @Test
    public void testChestCardsAreNotAlwaysInSameOrder() throws IOException {

        boolean oneTwo = false;
        boolean twoOne = false;

        for (int i = 0; i < 100; i++) {
            Deck.addCommunityChestCards(new ArrayList<>());
            List<Card> CommunityChestCards = Deck.getCommunityChestCards();
            assertEquals(0, CommunityChestCards.size());

            List<Card> mimicOutputFromCardLoadMethod = new ArrayList<>();
            Card card1 = new MoveForwardSpecific("", "");
            Card card2 = new Transaction("",0,"");
            mimicOutputFromCardLoadMethod.add(card1);
            mimicOutputFromCardLoadMethod.add(card2);

            Deck.addCommunityChestCards(mimicOutputFromCardLoadMethod);
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
    public void testChanceCardsAreNotAlwaysInSameOrder() throws IOException {

        boolean oneTwo = false;
        boolean twoOne = false;

        for (int i = 0; i < 100; i++) {
            Deck.addChanceCards(new ArrayList<>());
            List<Card> ChanceCards = Deck.getChanceCards();
            assertEquals(0, ChanceCards.size());

            List<Card> mimicOutputFromCardLoadMethod = new ArrayList<>();
            Card card1 = new MoveForwardSpecific("", "");
            Card card2 = new Transaction("",0,"");
            mimicOutputFromCardLoadMethod.add(card1);
            mimicOutputFromCardLoadMethod.add(card2);

            Deck.addChanceCards(mimicOutputFromCardLoadMethod);
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
}
