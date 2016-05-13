package game.interactors.movetoken;

import game.entities.Board;
import game.interactors.Interactor;
import game.manager.StateManager;
import game.presenters.Presenter;

import static game.Context.currentPlayer;
import static game.manager.StateImpl.LAND_ON;
import static game.manager.StateImpl.PAY_SALARY;

public class MoveToken extends Interactor {

    private final MoveTokenBoardGateway board;
    private final MoveTokenStateManager manager;
    private final MoveTokenPresenter presenter;
    private final MoveTokenResponse response = new MoveTokenResponse();

    public MoveToken(Board board, StateManager manager, Presenter presenter) {
        this.board = board;
        this.manager = manager;
        this.presenter = presenter;
    }

    @Override
    public void handle() {
        if (board.move(currentPlayer)) {
            manager.setState(PAY_SALARY);
            response.GO = board.getInitialSpaceDescription();
            presenter.passGoMessage(response);
        } else manager.setState(LAND_ON);
    }
}
