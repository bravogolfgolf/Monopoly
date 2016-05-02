package game.entities;

public class Dice {

    private static int rolled;
    private static boolean doubles;

    public Dice(int rolled, boolean doubles) {
        Dice.rolled = rolled;
        Dice.doubles = doubles;
    }

    public static void roll() {
        int firstDie = rollDie();
        int secondDie = rollDie();
        rolled = firstDie + secondDie;
        doubles = (firstDie == secondDie);
    }

    private static int rollDie() {
        return (int) (Math.random() * 6) + 1;
    }

    public static int rolled() {
        return rolled;
    }

    public static boolean isDoubles() {
        return doubles;
    }
}