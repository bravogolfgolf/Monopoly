package pkg.board.domain;

import org.junit.Test;
import pkg.game.OwnershipMultiplier;
import pkg.game.Player;
import pkg.game.SourceOfMoveMultiplier;

import static org.junit.Assert.assertEquals;

public class LuxuryTaxTest {


    @Test
    public void testLandOnLuxuryTaxAndCashDecreasesBy75(){
    final int AFTER_TAX_BALANCE = 1425;
        LuxuryTax luxuryTax = new LuxuryTax("Luxury Tax");
        Player player = new Player("Cat");
        luxuryTax.landOn(player, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        assertEquals(AFTER_TAX_BALANCE, player.getCashBalance());
    }
}
