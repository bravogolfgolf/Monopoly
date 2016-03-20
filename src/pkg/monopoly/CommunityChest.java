package pkg.monopoly;

import pkg.card.Card;

public class CommunityChest extends Space {
    public CommunityChest(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player, SourceOfMoveMultiplier sourceOfMoveMultiplier, OwnershipMultiplier ownershipMultiplier) {
        Card card = Card.drawCard("Community Chest");
        card.action(player);
    }

}
