package game.interactors.passgo;

import game.entities.Board;
import game.interactors.Interactor;
import game.presenters.Presenter;

import static game.Context.currentPlayer;
import static game.entities.Token.TransactionType.RECIEVE_CASH;

public class PassGo extends Interactor {

    private final PassGoPresenter presenter;
    private final PassGoResponse response = new PassGoResponse();
    private final PassGoBoardGateway board;

    public PassGo(Presenter presenter, Board board) {
        this.presenter = presenter;
        this.board = board;
    }

    @Override
    public void handle() {
        currentPlayer.turnState.passedGO = false;
        currentPlayer.transaction(200, RECIEVE_CASH);
        response.GO = board.findSpaceBy(0).getDescription();
        presenter.passGoMessage(response);
    }
}