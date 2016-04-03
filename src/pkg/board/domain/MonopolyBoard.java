package pkg.board.domain;

import pkg.game.Board;

import java.io.IOException;

import java.util.Iterator;
import java.util.List;

public class MonopolyBoard implements Board {

    private final List<Space> board;

    public MonopolyBoard(String localization, SpaceFactory spaceFactory) throws IOException {

        board = spaceFactory.load(localization);
        for (int i = 0; i < board.size() - 1; i++)
            board.get(i).setNextSpace(board.get(i + 1));
        board.get(board.size() - 1).setNextSpace(board.get(0));
    }

    @Override
    public Iterator<Space> iterator() {
        return board.iterator();
    }

    @Override
    public int size() {
        return board.size();
    }

    @Override
    public Space getSpace(int number) {
        return board.get(number);
    }
}
