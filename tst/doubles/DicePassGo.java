package game.doubles;

import game.entities.Dice;

public class DicePassGo extends Dice {

    @Override
    public int rolled() {
        return 41;
    }

    @Override
    public boolean isDoubles() {
        return false;
    }
}
