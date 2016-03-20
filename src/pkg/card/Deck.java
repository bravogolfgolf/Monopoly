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

    public static List<Card> getCommunityChestCards() {
        return communityChestCards;
    }

    public static void addChanceCards(List<Card> chanceCards) {
        Deck.chanceCards = chanceCards;
    }

    public static List<Card> getChanceCards() {
        return chanceCards;
    }

    public static void randomizeCardOrder() {
        Collections.shuffle(communityChestCards);
        Collections.shuffle(chanceCards);
    }

    public static void clearCards() {
        communityChestCards.clear();
        chanceCards.clear();
    }

    public static Card drawCard(String deck) {
        Card card = null;
        if (deck.equals("Community Chest")) {
            card = communityChestCards.remove(0);
            if (isNotGetOutOfJail(card))
                communityChestCards.add(card);
        }

        if (deck.equals("Chance")) {
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
