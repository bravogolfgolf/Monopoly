package game.entities;

public class Dice {

    private int roll;
    private boolean doubles;

    public void roll() {
        int die1 = rollDie();
        int die2 = rollDie();
        roll = die1 + die2;
        doubles = (die1 == die2);
    }

    private int rollDie() {
        return (int) (Math.random() * 6) + 1;
    }

    public int rolled() {
        return roll;
    }

    public boolean isDoubles() {
        return doubles;
    }
}