package game.doubles;

public class DiceDoubleOnes extends game.entities.Dice {

    @Override
    public int rolled() {
        return 2;
    }

    @Override
    public boolean isDoubles() {
        return true;
    }
}
