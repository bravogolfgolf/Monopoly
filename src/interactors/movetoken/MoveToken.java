package game.interactors.movetoken;

import game.controllers.ControllerRequest;
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
    public void handle(ControllerRequest request) {
        Token token = players.getCurrentPlayer();
        boolean passedGO = board.movesPassedGO(token, request.dice.rolled());
        response.dice = request.dice;
        presenter.rollMessage(response);
        if (passedGO)
            presenter.passedGOMessage(response);
    }
}
