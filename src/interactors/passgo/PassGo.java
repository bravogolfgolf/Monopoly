package game.interactors.passgo;

import game.entities.Banker;
import game.entities.Board;
import game.interactors.Interactor;
import game.presenters.Presenter;

public class PassGo extends Interactor {

    private final PassGoPresenter presenter;
    private final PassGoBankerGateway banker;
    private final PassGoBoardGateway board;
    private final PassGoResponse response = new PassGoResponse();

    public PassGo(Presenter presenter, Banker banker, Board board) {
        this.presenter = presenter;
        this.banker = banker;
        this.board = board;
    }

    @Override
    public void handle() {
        banker.paySalary();
        response.GO = board.getInitialSpaceDescription();
        presenter.passGoMessage(response);
    }
}