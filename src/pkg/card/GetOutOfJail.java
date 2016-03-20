package pkg.card;

import pkg.monopoly.Player;

class GetOutOfJail extends Card {
    GetOutOfJail(String cardText) {
        setCardText(cardText);
    }

    @Override
    boolean isGetOutOfJailCard() {
        return true;
    }

    @Override
    public void action(Player player) {
        player.addCard(this);
    }
}
