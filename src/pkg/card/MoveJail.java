package pkg.card;

import pkg.monopoly.OwnershipMultiplier;
import pkg.monopoly.Player;
import pkg.monopoly.SourceOfMoveMultiplier;
import pkg.board.domain.Space;

class MoveJail extends Card {
    private final String destination;

    MoveJail(String cardText, String destination) {
        this.cardText = cardText;
        this.destination = destination;
    }

    @Override
    boolean isGetOutOfJailCard() {
        return false;
    }

    @Override
    public void action(Player player) {
        Space space = player.getSpace();
        Space goToJail = space.searchForSpaceByDescription(destination);
        goToJail.landOn(player, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
    }
}
