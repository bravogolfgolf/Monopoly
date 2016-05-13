package game.entities;

import game.entities.Board.Space;

public class Token implements Comparable {

    public Space space;
    public int move;
    public enum TransactionType {PAY_CASH, RECIEVE_CASH, BUY_PROPERTY, MORTGAGE_PROPERTY, UN_MORTGAGE_PROPERTY}

    private final String description;
    private int cashBalance = 1500;
    private int netWorth = 1500;

    public Token(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Object o) {
        return this.description.compareTo(((Token) o).description);
    }

    public int cashBalance() {
        return cashBalance;
    }

    public int netWorth() {
        return netWorth;
    }

    public void transaction(int amount, TransactionType type) {
        switch (type) {
            case RECIEVE_CASH:
                cashBalance += amount;
                netWorth += amount;
                break;
            case PAY_CASH:
                cashBalance -= amount;
                netWorth -= amount;
                break;
            case BUY_PROPERTY:
                cashBalance -= amount;
                netWorth += (amount / 2);
                break;
            case MORTGAGE_PROPERTY:
                cashBalance += amount / 2;
                break;
            case UN_MORTGAGE_PROPERTY:
                cashBalance -= (amount / 2) * 1.1;
                break;
        }
    }
}
