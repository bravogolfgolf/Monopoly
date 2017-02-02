package game.interactors.movetoken;

import game.entities.Token;

public interface MoveTokenBoardGateway {

    boolean move(Token currentPlayer);

    String getInitialSpaceDescription();
}
