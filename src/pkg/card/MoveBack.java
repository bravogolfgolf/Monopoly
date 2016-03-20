package pkg.card;

import pkg.monopoly.OwnershipMultiplier;
import pkg.monopoly.Player;
import pkg.monopoly.SourceOfMoveMultiplier;
import pkg.monopoly.Space;

public class MoveBack extends Card {
    public MoveBack( String cardText) {
        setCardText(cardText);
    }

    @Override
    boolean isGetOutOfJailCard() {
        return false;
    }

    @Override
    public void action(Player player)  {
        Space currentSpace = player.getSpace();
        Space nextSpace = currentSpace.getNextSpace();
        for (int i = 0; i < 36; i++) {
            currentSpace = nextSpace;
            nextSpace = currentSpace.getNextSpace();
        }
        player.setSpace(nextSpace);
        nextSpace.landOn(player, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
    }
}
