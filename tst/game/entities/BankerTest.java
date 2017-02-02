package game.entities;

import org.junit.Before;
import org.junit.Test;

import static game.Context.currentPlayer;
import static org.junit.Assert.assertEquals;

public class BankerTest {

    private Banker banker;

    @Before
    public void setup() {
        currentPlayer = new Token("Cat");
        banker = new Banker();
    }

    @Test
    public void testPaySalary() {
        banker.paySalary();

        assertEquals(1700, currentPlayer.cashBalance());
        assertEquals(1700, currentPlayer.netWorth());
    }

    @Test
    public void testCollectIncomeTax_LessThan2000() {
        banker.collectIncomeTax();

        assertEquals(1350, currentPlayer.cashBalance());
        assertEquals(1350, currentPlayer.netWorth());
    }

    @Test
    public void testCollectIncomeTax_GreaterOrEqual2000() {
        currentPlayer.transaction(500, Token.TransactionType.RECIEVE_CASH);

        banker.collectIncomeTax();

        assertEquals(1800, currentPlayer.cashBalance());
        assertEquals(1800, currentPlayer.netWorth());
    }
}
