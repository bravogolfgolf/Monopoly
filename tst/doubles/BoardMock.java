package game.doubles;

import game.entities.Board;

import java.util.List;

public class BoardMock extends Board {

    public boolean verifyMoveCalled = false;

    public BoardMock(List<Space> board) {
        super(board);
    }

    @Override
    public Space move(int spaceID, int forward) {
        verifyMoveCalled = true;
        return new Space.Go(20,"Free Parking");
    }
}