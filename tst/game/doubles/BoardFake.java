package game.doubles;

import game.entities.Board;
import game.entities.Token;

import java.util.List;

public class BoardFake extends Board {

    public boolean verifyMoveCalled = false;
    public boolean verifySetInitialSpaceCalled = false;
    public boolean verifyGetInitialSpaceDescriptionCalled = false;

    @Override
    public String getInitialSpaceDescription() {
        verifyGetInitialSpaceDescriptionCalled = true;
        return "";
    }

    public BoardFake(List<Space> board) {
        super(board);
    }

    @Override
    public boolean move(Token token) {
        verifyMoveCalled = true;
        return token.getMove() == 41;
    }

    @Override
    public void setInitialSpace(Token token) {
        verifySetInitialSpaceCalled = true;
    }
}