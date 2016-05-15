package game.doubles;

import game.entities.Dice;

public class DiceRollTen extends Dice {

    @Override
    public int rolled() {
        return 10;
    }

    @Override
    public boolean isDoubles() {
        return false;
    }
}
