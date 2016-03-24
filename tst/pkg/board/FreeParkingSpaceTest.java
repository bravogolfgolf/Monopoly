package pkg.board;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pkg.monopoly.OwnershipMultiplier;
import pkg.monopoly.Player;
import pkg.monopoly.SourceOfMoveMultiplier;

import static org.junit.Assert.assertEquals;

public class FreeParkingSpaceTest {

    private Player player;
    private FreeParking freeParking;

    @Before
    public void setUp() {
        player = new Player("Cat");
        freeParking = new FreeParking("Free Parking");
    }

    @After
    public void teardown() {
        player = null;
        freeParking = null;
    }

    @Test
    public void testLandOn()  {
        int expectedEndingBalance = player.getCashBalance();
        freeParking.landOn(player, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }

    @Test
    public void testPassBy() {
        int expectedEndingBalance = player.getCashBalance();
        freeParking.passBy(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }
}
