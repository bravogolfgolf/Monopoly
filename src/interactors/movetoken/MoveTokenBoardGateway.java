package game.interactors.movetoken;

import game.entities.Token;

public interface MoveTokenBoardGateway {

    void move(Token currentPlayer, int number);
}
