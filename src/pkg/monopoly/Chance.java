package pkg.monopoly;

import pkg.card.*;

public class Chance extends Space {
    public Chance(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player, SourceOfMoveMultiplier sourceOfMoveMultiplier, OwnershipMultiplier ownershipMultiplier)  {
        Card card = Deck.drawCard("Chance");
        card.action(player);
    }
}
