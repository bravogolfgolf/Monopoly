package game.doubles;

import game.entities.Dice;

public class DiceRollSeven extends Dice {

    @Override
    public int rolled() {
        return 7;
    }

    @Override
    public boolean isDoubles() {
        return false;
    }
}
