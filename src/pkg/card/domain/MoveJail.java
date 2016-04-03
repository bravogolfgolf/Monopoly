package pkg.card.domain;

import pkg.game.OwnershipMultiplier;
import pkg.game.Player;
import pkg.game.SourceOfMoveMultiplier;
import pkg.board.domain.Space;

public class MoveJail extends Card {
    private final String destination;

    public MoveJail(String cardText, String destination) {
        this.cardText = cardText;
        this.destination = destination;
    }

    @Override
    public boolean isGetOutOfJailCard() {
        return false;
    }

    @Override
    public void action(Player player) {
        Space space = player.getSpace();
        Space goToJail = space.searchForSpaceByDescription(destination);
        goToJail.landOn(player, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
    }
}
