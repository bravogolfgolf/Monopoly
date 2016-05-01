package game.interactors.movetoken;

import game.entities.Board;
import game.entities.Dice;
import game.entities.Token;

public interface MoveTokenBoardGateway {

    Board.Space move(Token token, Dice dice);
}