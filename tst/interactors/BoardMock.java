package game.interactors;

import game.entities.Board;
import game.entities.Dice;
import game.entities.Token;

import java.util.List;

public class BoardMock extends Board {

    boolean verifyMoveCalled = false;

    public BoardMock(List<Space> board) {
        super(board);
    }

    @Override
    public Space move(Token token, Dice dice) {
        verifyMoveCalled = true;
        return super.move(token, dice);
    }
}