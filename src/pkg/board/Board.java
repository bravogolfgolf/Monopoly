package pkg.board;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Board implements Iterable {

    private final List<Space> board;

    public Board(String localization) throws IOException {

        board = SpaceFactory.load(localization);
        for (int i = 0; i < board.size() - 1; i++)
            board.get(i).setNextSpace(board.get(i + 1));
        board.get(board.size() - 1).setNextSpace(board.get(0));
    }

    @Override
    public Iterator<Space> iterator() {
        return board.iterator();
    }

    public int size() {
        return board.size();
    }
}
