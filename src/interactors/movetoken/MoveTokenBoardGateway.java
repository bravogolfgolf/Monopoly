package game.interactors.movetoken;

import game.entities.Board;

public interface MoveTokenBoardGateway {

    Board.Space move(int spaceID, int forward);
}