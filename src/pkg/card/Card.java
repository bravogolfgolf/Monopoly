package pkg.card;

import pkg.monopoly.*;

public abstract class Card {

    String cardText;

    abstract boolean isGetOutOfJailCard();

    public abstract void action(Player player);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return cardText.equals(card.cardText);
    }

    @Override
    public int hashCode() {
        return cardText.hashCode();
    }

}