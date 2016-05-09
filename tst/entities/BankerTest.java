package game.entities;

import game.Context;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankerTest {

    @Test
    public void paySalary() {
        Context.currentPlayer = new Token("Cat");

        Banker banker = new Banker();
        banker.paySalary();

        assertEquals(1700,Context.currentPlayer.cashBalance());
        assertEquals(1700,Context.currentPlayer.netWorth());
    }
}
