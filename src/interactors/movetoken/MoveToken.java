package game.interactors.movetoken;

import game.entities.Board;
import game.interactors.Interactor;
import game.manager.StateManager;

import static game.Context.currentPlayer;
import static game.manager.StateImpl.LAND_ON;
import static game.manager.StateImpl.PASS_GO;

public class MoveToken extends Interactor {

    private final MoveTokenBoardGateway board;
    private final MoveTokenStateManager manager;

    public MoveToken(Board board, StateManager manager) {
        this.board = board;
        this.manager = manager;
    }

    @Override
    public void handle() {
        if (board.move(currentPlayer))
            manager.setState(PASS_GO);
        else manager.setState(LAND_ON);
    }
}
