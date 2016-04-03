package pkg.board.domain;

import pkg.game.OwnershipMultiplier;
import pkg.game.Player;
import pkg.game.SourceOfMoveMultiplier;

public class SpaceMockLandOnPassByCounter extends Space {

    int landOnCounter;
    int passByCounter;

    public SpaceMockLandOnPassByCounter(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player, SourceOfMoveMultiplier sourceOfMoveMultiplier, OwnershipMultiplier ownershipMultiplier) {
        landOnCounter++;
    }

    @Override
    public void passBy(Player player) {
        passByCounter++;
    }
}
