package game.doubles;

import game.entities.Dice;

public class DiceRollFour extends Dice {

    @Override
    public int rolled() {
        return 4;
    }

    @Override
    public boolean isDoubles() {
        return false;
    }
}
