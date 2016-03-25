package pkg.card.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    public enum DeckType {
        CHEST, CHANCE
    }

    private static List<Card> chanceCards = new ArrayList<>();
    private static List<Card> communityChestCards = new ArrayList<>();

    public static void create(DeckFactory deckFactory, DeckType deckType, String localization) throws IOException {
        List<Card> cards = deckFactory.load(deckType, localization);
        if (deckType.equals(DeckType.CHEST))
            communityChestCards = cards;
        if (deckType.equals(DeckType.CHANCE))
            chanceCards = cards;
    }

    public static void addCommunityChestCards(List<Card> communityChestCards) {
        randomizeCardOrder(communityChestCards);
        Deck.communityChestCards = communityChestCards;
    }

    public static List<Card> getCommunityChestCards() {
        return communityChestCards;
    }

    public static void addChanceCards(List<Card> chanceCards) {
        randomizeCardOrder(chanceCards);
        Deck.chanceCards = chanceCards;
    }

    static List<Card> getChanceCards() {
        return chanceCards;
    }

    private static void randomizeCardOrder(List<Card> cards) {
        Collections.shuffle(cards);
    }

    public static Card drawCard(DeckType deckType) {
        Card card = null;
        if (deckType.equals(DeckType.CHEST)) {
            card = communityChestCards.remove(0);
            if (isNotGetOutOfJail(card))
                communityChestCards.add(card);
        }

        if (deckType.equals(DeckType.CHANCE)) {
            card = chanceCards.remove(0);
            if (isNotGetOutOfJail(card))
                chanceCards.add(card);
        }
        return card;
    }

    private static boolean isNotGetOutOfJail(Card card) {
        return !card.isGetOutOfJailCard();
    }
}
