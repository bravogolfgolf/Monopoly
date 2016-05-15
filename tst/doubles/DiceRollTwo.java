package game.doubles;

import game.entities.Dice;

public class DiceRollTwo extends Dice {

    @Override
    public int rolled() {
        return 2;
    }

    @Override
    public boolean isDoubles() {
        return false;
    }
}
