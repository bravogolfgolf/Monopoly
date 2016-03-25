package pkg.board;

import pkg.monopoly.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board implements Iterable {

    private final List<Space> board;

    public Board(String localization, SpaceFactory spaceFactory) throws IOException {

        board = spaceFactory.load(localization);
        for (int i = 0; i < board.size() - 1; i++)
            board.get(i).setNextSpace(board.get(i + 1));
        board.get(board.size() - 1).setNextSpace(board.get(0));
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
    public Iterator<Space> iterator() {
        return board.iterator();
    }

    public int size() {
        return board.size();
    }

    public Space getSpace(int number){
        return board.get(number);
    }
}
