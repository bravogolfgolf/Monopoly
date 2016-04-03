package pkg.game;

import pkg.board.domain.RealEstate;
import pkg.board.domain.Space;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface Board extends Iterable {

    static List<RealEstate> getAllRealEstateOf(Player player) {
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
    Iterator<Space> iterator();

    int size();

    Space getSpace(int number);
}
