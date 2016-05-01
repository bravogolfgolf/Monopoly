package game.doubles;

import game.entities.Board;
import game.entities.Token;

import java.util.List;

public class BoardFake extends Board {

    public boolean verifyMoveCalled = false;

    public BoardFake(List<Space> board) {
        super(board);
    }

    @Override
    public boolean movesPassedGO(Token token, int forward) {
        verifyMoveCalled = true;
        return (forward %2 == 0);
    }
}