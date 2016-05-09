package game.interactors.movetoken;

import game.entities.Dice;
import game.interactors.Interactor;
import game.presenters.Presenter;

import static game.Context.currentPlayer;
import static game.Context.dice;

public class MoveToken extends Interactor {

    private final MoveTokenPresenter presenter;
    private final MoveTokenBoardGateway board;
    private final MoveTokenResponse response = new MoveTokenResponse();

    public MoveToken(Presenter presenter, MoveTokenBoardGateway board) {
        this.presenter = presenter;
        this.board = board;
    }

    @Override
    public void handle() {
        dice = Dice.roll();
        board.move(currentPlayer, dice.rolled());
        response.rolled = dice.rolled();
        response.isDoubles = dice.isDoubles();
        presenter.rollMessage(response);
    }
}
