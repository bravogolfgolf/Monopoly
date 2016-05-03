package game.interactors.passgo;

import game.entities.Board;
import game.interactors.Interactor;
import game.presenters.Presenter;

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
        response.GO = board.findSpaceBy(0).getDescription();
        presenter.passGoMessage(response);
    }
}