package game.doubles;

import game.entities.Dice;

public class DiceRollFive extends Dice {

    @Override
    public int rolled() {
        return 5;
    }

    @Override
    public boolean isDoubles() {
        return false;
    }
}
