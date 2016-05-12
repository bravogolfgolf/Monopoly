package game.interactors.movetoken;

import game.Context;
import game.entities.Board;
import game.interactors.Interactor;

public class MoveToken extends Interactor {

    private MoveTokenBoardGateway board;

    public MoveToken(Board board) {
        this.board = board;
    }

    @Override
    public void handle() {
        board.move(Context.currentPlayer, 1);
    }
}
