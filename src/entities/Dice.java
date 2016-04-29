package game.entities;

public class Dice {

    private int roll;

    public boolean roll() {
        int die1 = rollDie();
        int die2 = rollDie();
        roll = die1 + die2;
        return (die1 == die2);
    }

    private int rollDie() {
        return (int) (Math.random() * 6) + 1;
    }

    public int getRoll() {
        return roll;
    }
}