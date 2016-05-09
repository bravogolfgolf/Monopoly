package game.doubles;

import game.entities.Board.Space;
import game.entities.Token;

public class TokenMock extends Token {

    public TokenMock(String description) {
        super(description);
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public Space getSpace() {
        return new Space.Go(0,"GO");
    }

    @Override
    public void setSpace(Space space) {

    }

    @Override
    public int cashBalance() {
        return -1;
    }

    @Override
    public int netWorth() {
        return -1;
    }

    @Override
    public void transaction(int amount, TransactionType type) {
    }
}
