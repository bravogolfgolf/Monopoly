package usecases;

import main.Monopoly;
import org.junit.Test;

public class MainTest {

    @Test
    public void testMain() {
        Monopoly game = new Monopoly();
        game.main(new String[0]);
    }
}