package pkg.card;

import pkg.monopoly.Player;

class GetOutOfJail extends Card {
    GetOutOfJail(String cardText) {
        this.cardText = cardText;
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
