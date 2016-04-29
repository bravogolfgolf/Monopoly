package game.entities;

public class Dice {

    private int rolled;
    private boolean doubles;

    public void roll() {
        int firstDie = rollDie();
        int secondDie = rollDie();
        rolled = firstDie + secondDie;
        doubles = (firstDie == secondDie);
    }

    private int rollDie() {
        return (int) (Math.random() * 6) + 1;
    }

    public int rolled() {
        return rolled;
    }

    public boolean isDoubles() {
        return doubles;
    }
}