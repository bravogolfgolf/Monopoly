package pkg.game;

class PlayerMockTurnCounter extends Player {

    int turnsTaken = 0;

    PlayerMockTurnCounter() {
        super("PlayerMockTurnCounter");
    }

    @Override
    public void takeATurn(Dice die) {
        turnsTaken++;
    }
}