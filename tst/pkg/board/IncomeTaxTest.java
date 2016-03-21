package pkg.board;

import org.junit.Before;
import org.junit.Test;
import pkg.board.IncomeTax;
import pkg.board.Space;
import pkg.monopoly.OwnershipMultiplier;
import pkg.monopoly.Player;
import pkg.monopoly.SourceOfMoveMultiplier;

import static org.junit.Assert.assertEquals;

public class IncomeTaxTest {

    private IncomeTax incomeTax;
    private Player player;

    @Before
    public void setUp() {
        incomeTax = (IncomeTax) Space.create("IncomeTax","Income Tax");
        player = new Player("Cat");
    }

    @Test
    public void testLandOnIncomeTaxWithLessThanOrEqualTo2000InNetWorth() {
        final int AFTER_TAX_BALANCE = 1350;
        incomeTax.landOn(player, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        assertEquals(AFTER_TAX_BALANCE, player.getCashBalance());
        assertEquals(AFTER_TAX_BALANCE, player.getNetWorth());

    }

    @Test
    public void testLandOnIncomeTaxWithGreaterThan2000InNetWorth() {
        final int AFTER_TAX_BALANCE = 1900;
        player.transaction(600, 600, Player.TransactionType.CASH);
        incomeTax.landOn(player, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        assertEquals(AFTER_TAX_BALANCE, player.getCashBalance());
        assertEquals(AFTER_TAX_BALANCE, player.getNetWorth());

    }
}
