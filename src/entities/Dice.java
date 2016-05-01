package game.entities;

public class Dice {

    private final int rolled;
    private final boolean doubles;

    protected Dice(int rolled, boolean doubles) {
        this.rolled = rolled;
        this.doubles = doubles;
    }

    public static Dice roll() {
        int firstDie = rollDie();
        int secondDie = rollDie();
        int rolled = firstDie + secondDie;
        boolean doubles = (firstDie == secondDie);
        return new Dice(rolled,doubles);
    }

    private static int rollDie() {
        return (int) (Math.random() * 6) + 1;
    }

    public int rolled() {
        return rolled;
    }

    public boolean isDoubles() {
        return doubles;
    }
}