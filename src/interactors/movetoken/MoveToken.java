package game.interactors.movetoken;

import game.Context;
import game.entities.Dice;
import game.entities.Token;
import game.interactors.Interactor;
import game.presenters.Presenter;

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
        Context.dice = Dice.roll();
        Token token = Context.currentPlayer;
        board.move(token, Context.dice.rolled());
        response.rolled = Context.dice.rolled();
        response.isDoubles = Context.dice.isDoubles();
        presenter.rollMessage(response);
    }
}
