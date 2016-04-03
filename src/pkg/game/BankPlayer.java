package pkg.game;

class BankPlayer extends Player {

    BankPlayer() {
        super("Bank");
    }

    @Override
    public boolean isBank() {
        return true;
    }
}
