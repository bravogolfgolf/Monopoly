package pkg.board.domain;

import pkg.game.OwnershipMultiplier;
import pkg.game.Player;
import pkg.game.SourceOfMoveMultiplier;

public class GoToJail extends Space {

    public GoToJail(String description) {
        setDescription(description);
    }

    public class GoToJailException extends RuntimeException {
    }

    @Override
    public void landOn(Player player, SourceOfMoveMultiplier sourceOfMoveMultiplier, OwnershipMultiplier ownershipMultiplier) {
        throw new GoToJailException();
    }
}
