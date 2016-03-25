package pkg.board.domain;

import pkg.monopoly.Basis;
import pkg.monopoly.OwnershipMultiplier;
import pkg.monopoly.SourceOfMoveMultiplier;

public class Utility extends Property {

    public Utility(String description, String group, int price) {
        super(description, group, price, 1, 1, 1, 1, 1, 1);
    }

    @Override
    protected int calculateRentOwed(Basis basis, OwnershipMultiplier ownershipMultiplier, SourceOfMoveMultiplier sourceOfMoveMultiplier) {
        return getNumberRolled() * basis.value() * ownershipMultiplier.value() * sourceOfMoveMultiplier.value();
    }
}