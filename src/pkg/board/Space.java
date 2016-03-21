package pkg.board;

import pkg.monopoly.Player;
import pkg.monopoly.SourceOfMoveMultiplier;
import pkg.monopoly.OwnershipMultiplier;

import java.util.ArrayList;
import java.util.List;

public abstract class Space {

    private String description = "";
    private String group = "";
    private Space nextSpace;
    private int numberRolled;

    void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    void setGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public boolean isRailroad() {
        return group.equals("Railroad");
    }

    boolean isUtility() {
        return group.equals("Utility");
    }

    public void setNextSpace(Space space) {
        nextSpace = space;
    }

    public Space getNextSpace() {
        return nextSpace;
    }

    public void move(Player player, int numberRolled, SourceOfMoveMultiplier sourceOfMoveMultiplier, OwnershipMultiplier ownershipMultiplier) {
        this.numberRolled = numberRolled;
        for (int i = 1; i < numberRolled; i++) {
            moveForwardOneSpace(player);
            player.getSpace().passBy(player);
        }
        moveForwardOneSpace(player);
        player.getSpace().landOn(player, sourceOfMoveMultiplier, ownershipMultiplier);
    }

    private void moveForwardOneSpace(Player player) {
        Space space = player.getSpace();
        Space next = space.getNextSpace();
        player.setSpace(next);
    }

    public void passBy(Player player) {
    }

    public void landOn(Player player, SourceOfMoveMultiplier sourceOfMoveMultiplier, OwnershipMultiplier ownershipMultiplier) {
    }

    public Space searchForSpaceByDescription(String description) {
        Space currentSpace = this;
        Space nextSpace = currentSpace.getNextSpace();

        while (!nextSpace.getDescription().equals(description)) {
            currentSpace = nextSpace;
            nextSpace = currentSpace.getNextSpace();
        }
        return nextSpace;
    }

    public Space searchForNextSpaceInGroup(String group) {
        Space currentSpace = this;
        Space nextSpace = currentSpace.getNextSpace();

        while (!nextSpace.getGroup().equals(group)) {
            currentSpace = nextSpace;
            nextSpace = currentSpace.getNextSpace();
        }
        return nextSpace;
    }

    public int getNumberOfSpacesTo(String description) {
        int result = 0;
        Space currentSpace = this;
        Space nextSpace = currentSpace.getNextSpace();
        Space destinationSpace = searchForSpaceByDescription(description);
        while (!currentSpace.equals(destinationSpace)) {
            currentSpace = nextSpace;
            nextSpace = currentSpace.getNextSpace();
            result++;
        }
        return result;
    }

    public static List<RealEstate> getAllRealEstateOf(Player player) {
        List<RealEstate> realEstateHoldings = new ArrayList<>();
        Space startingSpace = player.getSpace();
        Space currentSpace = startingSpace;
        Space nextSpace = currentSpace.getNextSpace();
        while (!nextSpace.equals(startingSpace)) {
            if (nextSpace.getClass().getSimpleName().equals("RealEstate")) {
                RealEstate realEstate = (RealEstate) nextSpace;
                if (realEstate.getOwner().equals(player)) {
                    realEstateHoldings.add(realEstate);
                }
            }
            currentSpace = nextSpace;
            nextSpace = currentSpace.getNextSpace();
        }
        return realEstateHoldings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Space space = (Space) o;

        return description.equals(space.description) && (nextSpace != null ? nextSpace.equals(space.nextSpace) : space.nextSpace == null && group.equals(space.group));

    }

    @Override
    public int hashCode() {
        int result = description.hashCode();
        result = 31 * result + (nextSpace != null ? nextSpace.hashCode() : 0);
        result = 31 * result + group.hashCode();
        return result;
    }

    public SourceOfMoveMultiplier getSourceOfMoveMultiplier() {
        if (this.isRailroad())
            return new SourceOfMoveMultiplier(2);
        if (this.isUtility())
            return new SourceOfMoveMultiplier(10);
        return new SourceOfMoveMultiplier();
    }

    public OwnershipMultiplier getOwnershipMultiplier() {
        if (this.isRailroad())
            return new OwnershipMultiplier();
        if (this.isUtility())
            return new OwnershipMultiplier(1);
        return new OwnershipMultiplier();
    }

    int getNumberRolled() {
        return numberRolled;
    }

    public void setNumberRolled(int numberRolled) {
        this.numberRolled = numberRolled;
    }
}