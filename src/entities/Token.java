package game.entities;

public class Token implements Comparable {

    final TurnState turnState = new TurnState();

    public enum TransactionType {PAY_CASH, RECIEVE_CASH, BUY_PROPERTY, MORTGAGE_PROPERTY, UN_MORTGAGE_PROPERTY}

    private static final int INITIAL_STARTING_SPACE_ID = 0;
    private final String description;
    private int spaceID = INITIAL_STARTING_SPACE_ID;
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

    public int getSpaceID() {
        return spaceID;
    }

    public void setSpaceID(int spaceID) {
        this.spaceID = spaceID;
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

    class TurnState {
        boolean passedGO = false;
    }
}
