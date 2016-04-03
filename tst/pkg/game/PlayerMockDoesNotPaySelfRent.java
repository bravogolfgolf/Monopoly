package pkg.game;

public class PlayerMockDoesNotPaySelfRent extends Player {
    public int changeCashBalanceBy = 0;

    public PlayerMockDoesNotPaySelfRent() {
        super("PlayerMockDoesNotPaySelfRent");
    }

    @Override
    public void transaction(int cashAmount, int netWorthAmount, TransactionType transactionType) {
        changeCashBalanceBy++;
    }
}
