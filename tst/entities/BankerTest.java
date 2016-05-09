package game.entities;

import org.junit.Test;

import static game.Context.currentPlayer;
import static org.junit.Assert.assertEquals;

public class BankerTest {

    @Test
    public void paySalary() {
        currentPlayer = new Token("Cat");

        Banker banker = new Banker();
        banker.paySalary();

        assertEquals(1700, currentPlayer.cashBalance());
        assertEquals(1700, currentPlayer.netWorth());
    }
}
