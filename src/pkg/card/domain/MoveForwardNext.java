package pkg.card.domain;

import pkg.game.OwnershipMultiplier;
import pkg.game.Player;
import pkg.game.SourceOfMoveMultiplier;
import pkg.board.domain.Space;

public class MoveForwardNext extends Card {
    private final String group;

    public MoveForwardNext(String cardText, String group) {
        this.cardText = cardText;
        this.group = group;
    }

    @Override
    public boolean isGetOutOfJailCard() {
        return false;
    }

    @Override
    public void action(Player player) {
        Space startingSpace = player.getSpace();
        Space endingSpace = startingSpace.searchForNextSpaceInGroup(group);
        String destination = endingSpace.getDescription();
        int numberOfSpacesToDestination = startingSpace.getNumberOfSpacesTo(destination);
        SourceOfMoveMultiplier sourceOfMoveMultiplier = endingSpace.getSourceOfMoveMultiplier();
        OwnershipMultiplier ownershipMultiplier = endingSpace.getOwnershipMultiplier();
        startingSpace.move(player, numberOfSpacesToDestination, sourceOfMoveMultiplier, ownershipMultiplier);
    }
}
