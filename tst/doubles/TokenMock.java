package game.doubles;

import game.entities.Token;

public class TokenMock extends Token {

    public boolean verifyTransactionCalled = false;

    public TokenMock(String description) {
        super(description);
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public int getSpaceID() {
        return -1;
    }

    @Override
    public void setSpaceID(int spaceID) {

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
        verifyTransactionCalled = true;
    }


}
