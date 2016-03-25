package pkg.board.domain;

import pkg.card.domain.Card;
import pkg.card.domain.Deck;
import pkg.monopoly.OwnershipMultiplier;
import pkg.monopoly.Player;
import pkg.monopoly.SourceOfMoveMultiplier;

public class CommunityChest extends Space {
    public CommunityChest(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player, SourceOfMoveMultiplier sourceOfMoveMultiplier, OwnershipMultiplier ownershipMultiplier) {
        Card card = Deck.drawCard(Deck.DeckType.CHEST);
        card.action(player);
    }
}
