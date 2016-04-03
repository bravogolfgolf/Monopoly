package pkg.card.domain;

import pkg.game.Player;

public class GetOutOfJail extends Card {
    public GetOutOfJail(String cardText) {
        this.cardText = cardText;
    }

    @Override
    public boolean isGetOutOfJailCard() {
        return true;
    }

    @Override
    public void action(Player player) {
        player.addCard(this);
    }
}
