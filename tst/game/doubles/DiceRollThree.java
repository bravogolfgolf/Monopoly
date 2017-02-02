package game.doubles;

import game.entities.Dice;

public class DiceRollThree extends Dice {

    @Override
    public int rolled() {
        return 3;
    }

    @Override
    public boolean isDoubles() {
        return false;
    }
}
