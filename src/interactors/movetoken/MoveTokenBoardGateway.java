package game.interactors.movetoken;

import game.entities.Board;
import game.entities.Token;

public interface MoveTokenBoardGateway {

    boolean movesPassedGO(Token token, int forward);

    Board.Space findSpaceBy(int spaceID);
}