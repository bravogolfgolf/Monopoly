package pkg.board.domain;

import pkg.card.domain.Card;
import pkg.card.domain.Deck;
import pkg.game.OwnershipMultiplier;
import pkg.game.Player;
import pkg.game.SourceOfMoveMultiplier;

public class Chance extends Space {
    public Chance(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player, SourceOfMoveMultiplier sourceOfMoveMultiplier, OwnershipMultiplier ownershipMultiplier) {
        Card card = Deck.drawCard(Deck.DeckType.CHANCE);
        card.action(player);
    }
}
