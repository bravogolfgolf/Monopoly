package pkg.card.domain;

import pkg.monopoly.OwnershipMultiplier;
import pkg.monopoly.Player;
import pkg.monopoly.SourceOfMoveMultiplier;
import pkg.board.domain.Space;

public class MoveForwardSpecific extends Card {
    private final String destination;

    public MoveForwardSpecific(String cardText, String destination) {
        this.cardText = cardText;
        this.destination = destination;
    }

    @Override
    public boolean isGetOutOfJailCard() {
        return false;
    }

    @Override
    public void action(Player player) {
        Space originalSpace = player.getSpace();
        int numberOfSpacesToDestination = originalSpace.getNumberOfSpacesTo(destination);
        originalSpace.move(player, numberOfSpacesToDestination, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
    }
}
