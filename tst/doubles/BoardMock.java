package game.doubles;

import game.entities.Board;
import game.entities.Token;

import java.util.List;

public class BoardMock extends Board {

    public boolean verifyMoveCalled = false;
    public boolean verifyFindBySpaceIDCalled = false;

    public BoardMock(List<Space> board) {
        super(board);
    }

    @Override
    public void move(Token token, int forward) {
        verifyMoveCalled = true;
    }

    @Override
    public Space findSpaceBy(int spaceID) {
        verifyFindBySpaceIDCalled = true;
        return new Space.Go(0, "GO");
    }
}