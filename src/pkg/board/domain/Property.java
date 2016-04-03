package pkg.board.domain;

import pkg.game.Player;
import pkg.game.Basis;
import pkg.game.SourceOfMoveMultiplier;
import pkg.game.OwnershipMultiplier;


import java.util.ArrayList;
import java.util.List;

public abstract class Property extends Space {

    Property(String description, String group, int price, int rent, int improvementOne, int improvementTwo, int improvementThree, int improvementFour, int improvementFive) {
        setDescription(description);
        setGroup(group);
        this.price = price;
        this.rentalBasis = new RentalBasis(rent, improvementOne, improvementTwo, improvementThree, improvementFour, improvementFive);
    }

    private final int price;
    final RentalBasis rentalBasis;
    private boolean isMortgaged;
    private Player owner = Player.newBank();
    private int numberOfImprovements;

    int getPrice() {
        return price;
    }

    void setIsMortgaged(boolean status) {
        isMortgaged = status;
    }

    boolean isMortgaged() {
        return isMortgaged;
    }

    int mortgageAmount() {
        return price / 2;
    }

    int unMortgageAmount() {
        return (int) -(mortgageAmount() * 1.10);
    }

    void mortgagedBy(Player player) {
        if (mortgageConditionsAreMeet(player)) {
            player.transaction(mortgageAmount(), 0, Player.TransactionType.MORTGAGE);
            setIsMortgaged(true);
        }
    }

    private boolean mortgageConditionsAreMeet(Player player) {
        return propertyIsNotMortgaged() && propertyIsOwnedByPlayer(player);
    }

    private boolean propertyIsOwnedByPlayer(Player player) {
        return getOwner().equals(player);
    }

    void unMortgageBy(Player player) {
        if (unMortgageConditionsAreMeet(player)) {
            player.transaction(unMortgageAmount(), mortgageAmount(), Player.TransactionType.UNMORTGAGE);
            setIsMortgaged(false);
        }
    }

    private boolean unMortgageConditionsAreMeet(Player player) {
        return isMortgaged() && propertyIsOwnedByPlayer(player);
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public void addImprovements() {
        numberOfImprovements++;
    }

    void removeImprovements() {
        numberOfImprovements--;
    }

    public int getImprovements() {
        return numberOfImprovements;
    }

    @Override
    public void landOn(Player player, SourceOfMoveMultiplier sourceOfMoveMultiplier, OwnershipMultiplier ownershipMultiplier) {
        if (playerIsNotOwner(player))
            if (propertyIsUnowned())
                // TODO Add ability to buy property or auction
                buyProperty(player);
            else if (propertyIsNotMortgaged()) {
                Basis basis = new Basis(rentalBasis.get(getImprovements()));
                if (ownershipMultiplier.isDefault())
                    ownershipMultiplier = overwriteOwnershipMultiplier();
                int rentOwed = calculateRentOwed(basis, ownershipMultiplier, sourceOfMoveMultiplier);
                payRent(player, rentOwed);
            }
    }

    private boolean playerIsNotOwner(Player player) {
        return !player.equals(this.getOwner());
    }

    private boolean propertyIsUnowned() {
        return owner.isBank();
    }

    private void buyProperty(Player player) {
        player.transaction(-price, mortgageAmount(), Player.TransactionType.PURCHASE);
        this.owner = player;
    }

    private boolean propertyIsNotMortgaged() {
        return !isMortgaged;
    }

    private OwnershipMultiplier overwriteOwnershipMultiplier() {
        List<Space> propertiesInGroup = getAllPropertiesInGroup();
        if (isRailroad()) {
            int exponent = getCountOfPropertiesInGroupWithSameOwner(propertiesInGroup) - 1;
            int ownershipMultiplier = (int) Math.pow(2, exponent);
            return new OwnershipMultiplier(ownershipMultiplier);
        }

        if (isUtility())
            if (allPropertiesHaveSameOwner(propertiesInGroup))
                return new OwnershipMultiplier(10);
            else
                return new OwnershipMultiplier(4);

        if (allPropertiesHaveSameOwner(propertiesInGroup) && isUnimproved())
            return new OwnershipMultiplier(2);

        return new OwnershipMultiplier();
    }

    List<Space> getAllPropertiesInGroup() {
        List<Space> properties = new ArrayList<>();
        properties.add(this);
        String group = this.getGroup();
        Space startingSpace = this;
        Space currentSpace = this;
        Space nextSpace = currentSpace.getNextSpace();
        while (!nextSpace.equals(startingSpace)) {
            if (nextSpace.getGroup().equals(group))
                properties.add(nextSpace);
            currentSpace = nextSpace;
            nextSpace = currentSpace.getNextSpace();
        }
        return properties;
    }

    int getCountOfPropertiesInGroupWithSameOwner(List<Space> properties) {
        Player thisOwner = this.getOwner();
        int ownerCount = 0;
        for (Space space : properties) {
            Property property = (Property) space;
            if (property.getOwner().equals(thisOwner))
                ownerCount++;
        }
        return ownerCount;
    }

    boolean allPropertiesHaveSameOwner(List<Space> properties) {
        Player thisOwner = this.getOwner();
        for (int i = 1; i < properties.size(); i++) {
            Property next = (Property) properties.get(i);
            if (!next.getOwner().equals(thisOwner))
                return false;
        }
        return true;
    }

    private boolean isUnimproved() {
        return numberOfImprovements == 0;
    }

    protected abstract int calculateRentOwed(Basis basis, OwnershipMultiplier ownershipMultiplier, SourceOfMoveMultiplier sourceOfMoveMultiplier);

    private void payRent(Player player, int rentOwed) {
        player.transaction(-rentOwed, -rentOwed, Player.TransactionType.CASH);
        this.owner.transaction(rentOwed, rentOwed, Player.TransactionType.CASH);
    }
}
