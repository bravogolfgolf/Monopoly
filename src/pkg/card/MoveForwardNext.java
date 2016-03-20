package pkg.card;

import pkg.monopoly.OwnershipMultiplier;
import pkg.monopoly.Player;
import pkg.monopoly.SourceOfMoveMultiplier;
import pkg.monopoly.Space;

class MoveForwardNext extends Card {
    private final String group;

    MoveForwardNext(String cardText, String group) {
        setCardText(cardText);
        this.group = group;
    }

    @Override
    boolean isGetOutOfJailCard() {
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
