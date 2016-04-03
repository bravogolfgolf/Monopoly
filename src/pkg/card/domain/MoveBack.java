package pkg.card.domain;

import pkg.game.OwnershipMultiplier;
import pkg.game.Player;
import pkg.game.SourceOfMoveMultiplier;
import pkg.board.domain.Space;

public class MoveBack extends Card {
    public MoveBack(String cardText) {
        this.cardText = cardText;
    }

    @Override
    public boolean isGetOutOfJailCard() {
        return false;
    }

    @Override
    public void action(Player player) {
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
