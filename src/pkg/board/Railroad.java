package pkg.board;

import pkg.monopoly.Basis;
import pkg.monopoly.OwnershipMultiplier;
import pkg.monopoly.SourceOfMoveMultiplier;

public class Railroad extends Property {

    public Railroad(String description, String group, int price, int rent) {
        super(description, group, price, rent, 1, 1, 1, 1, 1);
    }

    @Override
    protected int calculateRentOwed(Basis basis, OwnershipMultiplier ownershipMultiplier, SourceOfMoveMultiplier sourceOfMoveMultiplier) {
        return basis.value() * ownershipMultiplier.value() * sourceOfMoveMultiplier.value();
    }
}