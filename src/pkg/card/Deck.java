package pkg.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private static List<Card> communityChestCards = new ArrayList<>();
    private static List<Card> chanceCards = new ArrayList<>();

    public static void addCommunityChestCards(List<Card> communityChestCards) {
        Deck.communityChestCards = communityChestCards;
    }

    static List<Card> getCommunityChestCards() {
        return communityChestCards;
    }

    public static void addChanceCards(List<Card> chanceCards) {
        Deck.chanceCards = chanceCards;
    }

    static List<Card> getChanceCards() {
        return chanceCards;
    }

    public static void randomizeCardOrder() {
        Collections.shuffle(communityChestCards);
        Collections.shuffle(chanceCards);
    }

    public static Card drawCard(DeckFactory.DeckType deckType) {
        Card card = null;
        if (deckType.equals(DeckFactory.DeckType.CHEST)) {
            card = communityChestCards.remove(0);
            if (isNotGetOutOfJail(card))
                communityChestCards.add(card);
        }

        if (deckType.equals(DeckFactory.DeckType.CHANCE)) {
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
