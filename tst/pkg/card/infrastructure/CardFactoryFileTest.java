package pkg.card.infrastructure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pkg.card.domain.Card;
import pkg.card.domain.Deck;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CardFactoryFileTest {

    private CardFactoryFile cardFactoryFile;

    @Before
    public void setUp() throws Exception {
        cardFactoryFile = new CardFactoryFile();
    }

    @After
    public void tearDown() {
        cardFactoryFile = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCard1() {
        CardFactoryFile.create("Invalid", "Invalid");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCard2() {
        CardFactoryFile.create("Invalid", "Invalid", "Invalid");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCard3() {
        CardFactoryFile.create("Invalid", "Invalid", 1, "Invalid");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCard4() {
        CardFactoryFile.create("Invalid", "Invalid", 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoadCardException() throws IOException {
        cardFactoryFile.load(Deck.DeckType.CHEST, "EXCEPTION");
    }

    @Test
    public void testReadOfCardDefinitionFile() throws IOException {
        List<Card> expected = new ArrayList<>();
        Deck.create(cardFactoryFile, Deck.DeckType.CHEST,"TEST");
        expected.add(CardFactoryFile.create("Instruction1", "MoveForwardSpecific", "Go"));
        expected.add(CardFactoryFile.create("Instruction2", "Transaction", 100, "Bank"));
        expected.add(CardFactoryFile.create("Instruction2", "Repairs", 40, 115));
        List<Card> actual = Deck.getCommunityChestCards();
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.equals(actual));
        for (int index = 0; index < expected.size(); index++) {
            assertTrue(expected.get(index).equals(actual.get(index)));
        }
    }

}
