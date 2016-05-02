package game.interactors.movetoken;

import game.entities.Dice;
import game.entities.Token;
import game.interactors.Interactor;
import game.presenters.Presenter;

public class MoveToken extends Interactor {

    private final MoveTokenPresenter presenter;
    private final MoveTokenPlayerGateway players;
    private final MoveTokenBoardGateway board;
    private final MoveTokenResponse response = new MoveTokenResponse();

    public MoveToken(Presenter presenter, MoveTokenPlayerGateway players, MoveTokenBoardGateway board) {
        this.presenter = presenter;
        this.players = players;
        this.board = board;
    }

    @Override
    public void handle() {
        Token token = players.getCurrentPlayer();
        boolean passedGO = board.movesPassedGO(token, Dice.rolled());
        response.rolled = Dice.rolled();
        response.isDoubles = Dice.isDoubles();
        response.passedGO = passedGO;
        response.GO = board.findSpaceBy(0).getDescription();
        presenter.rollMessage(response);
    }
}
