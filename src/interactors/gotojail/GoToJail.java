package game.interactors.gotojail;

import game.entities.Board;
import game.interactors.Interactor;
import game.presenters.Presenter;

import static game.Context.currentPlayer;

public class GoToJail extends Interactor {

    private final GoToJailBoardGateway board;
    private final GoToJailPresenter presenter;
    private final GoToJailResponse response = new GoToJailResponse();

    public GoToJail(Board board, Presenter presenter) {
        this.board = board;
        this.presenter = presenter;
    }

    @Override
    public void handle() {
        currentPlayer.goToJail();
        response.GO = board.getInitialSpaceDescription();
        presenter.goToJailMessage(response);
    }
}
