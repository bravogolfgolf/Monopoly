package pkg.board.domain;

import pkg.game.Basis;
import pkg.game.OwnershipMultiplier;
import pkg.game.SourceOfMoveMultiplier;

public class Utility extends Property {

    public Utility(String description, String group, int price) {
        super(description, group, price, 1, 1, 1, 1, 1, 1);
    }

    @Override
    protected int calculateRentOwed(Basis basis, OwnershipMultiplier ownershipMultiplier, SourceOfMoveMultiplier sourceOfMoveMultiplier) {
        return getNumberRolled() * basis.value() * ownershipMultiplier.value() * sourceOfMoveMultiplier.value();
    }
}