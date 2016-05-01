package game.interactors.movetoken;

import game.controllers.ControllerRequest;
import game.entities.Board;
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

        response.dice = request.dice;
        presenter.rollMessage(response);

        Token token = players.getCurrentPlayer();
        response.token = token.getDescription();

        Board.Space space = board.move(token, request.dice);
        response.space = space.getDescription();

        presenter.moveMessage(response);
    }
}
