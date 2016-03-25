package pkg.card.domain;

import pkg.card.domain.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class DeckFactoryFakeTEST implements DeckFactory {
    private final List<Card> cards = new ArrayList<>();

    @Override
    public List<Card> load(Deck.DeckType deckType, String localization) throws IOException {
        cards.add(new MoveForwardSpecific("Advance to Go (Collect $200)", "Go"));
        cards.add(new Transaction("Bank error in your favor – Collect $200", 200, "Bank"));
        cards.add(new Repair("You are assessed for street repairs – $40 per house – $115 per hotel", 40, 115));
        return cards;
    }
}
