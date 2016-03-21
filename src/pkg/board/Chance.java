package pkg.board;

import pkg.card.Card;
import pkg.card.Deck;
import pkg.monopoly.OwnershipMultiplier;
import pkg.monopoly.Player;
import pkg.monopoly.SourceOfMoveMultiplier;

public class Chance extends Space {
    public Chance(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player, SourceOfMoveMultiplier sourceOfMoveMultiplier, OwnershipMultiplier ownershipMultiplier) {
        Card card = Deck.drawCard("Chance");
        card.action(player);
    }
}
