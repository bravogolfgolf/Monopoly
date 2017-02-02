package game.doubles;

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
