package pkg.card.domain;

import pkg.card.domain.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeckFactoryFakeUS implements DeckFactory {
    private final List<Card> cards = new ArrayList<>();

    @Override
    public List<Card> load(Deck.DeckType deckType, String localization) throws IOException {

        if (deckType.equals(Deck.DeckType.CHEST)) {
            cards.add(new MoveForwardSpecific("Advance to Go (Collect $200)", "Go"));
            cards.add(new Transaction("Bank error in your favor – Collect $200", 200, "Bank"));
            cards.add(new Transaction("Doctor's fees – Pay $50", -50, "Bank"));
            cards.add(new Transaction("From sale of stock you get $50", 50, "Bank"));
            cards.add(new GetOutOfJail("Get out of Jail Free – This card may be kept until needed or sold"));
            cards.add(new MoveJail("Go to Jail – Go directly to jail – Do not pass Go – Do not collect $200", "Go to Jail"));
            cards.add(new Transaction("Grand Opera Night – Collect $50 from every player for opening night seats", 50, "Players"));
            cards.add(new Transaction("Holiday Fund matures - Receive $100", 100, "Bank"));
            cards.add(new Transaction("Income tax refund – Collect $20", 20, "Bank"));
            cards.add(new Transaction("It is your birthday - Collect $10 from each player", 10, "Players"));
            cards.add(new Transaction("Life insurance matures – Collect $100", 100, "Bank"));
            cards.add(new Transaction("Pay hospital fees of $100", -100, "Bank"));
            cards.add(new Transaction("Pay school fees of $150", -150, "Bank"));
            cards.add(new Transaction("Receive $25 consultancy fee", 25, "Bank"));
            cards.add(new Repair("You are assessed for street repairs – $40 per house – $115 per hotel", 40, 115));
            cards.add(new Transaction("You have won second prize in a beauty contest – Collect $10", 10, "Bank"));
            cards.add(new Transaction("You inherit $100", 100, "Bank"));
        }

        if (deckType.equals(Deck.DeckType.CHANCE)) {
            cards.add(new MoveForwardSpecific("Advance to Go (Collect $200)", "Go"));
            cards.add(new MoveForwardSpecific("Advance to Illinois Ave. - If you pass Go, collect $200", "Illinois Avenue"));
            cards.add(new MoveForwardSpecific("Advance to St. Charles Place – If you pass Go, collect $200", "St. Charles Place"));
            cards.add(new MoveForwardNext("Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.", "Utility"));
            cards.add(new MoveForwardNext("Advance token to the nearest Railroad and pay owner twice the rental to which he is otherwise entitled. If Railroad is unowned, you may buy it from the Bank", "Railroad"));
            cards.add(new Transaction("Bank pays you dividend of $50", 50, "Bank"));
            cards.add(new GetOutOfJail("Get out of Jail Free – This card may be kept until needed or sold"));
            cards.add(new MoveBack("GGo Back 3 Spaces"));
            cards.add(new MoveJail("Go to Jail – Go directly to jail – Do not pass Go – Do not collect $200", "Go to Jail"));
            cards.add(new Repair("Make general repairs on all your property – For each house pay $25 – For each hotel $100", 25, 100));
            cards.add(new Transaction("Pay poor tax of $15", -15, "Bank"));
            cards.add(new MoveForwardSpecific("Take a trip to Reading Railroad", "Reading Railroad"));
            cards.add(new MoveForwardSpecific("Take a walk on the Boardwalk – Advance token to Boardwalk", "Boardwalk"));
            cards.add(new Transaction("You have been elected Chairman of the MonopolyBoard – Pay each player $50", -50, "Players"));
            cards.add(new Transaction("YYour building loan matures – Collect $150", 150, "Bank"));
        }
        return cards;
    }
}
