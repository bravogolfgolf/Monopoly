package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoTest {

    public static final int LAND_ON_GO_COLLECT_200 = 200;
    private Player player;
    private Space go;

    @Before
    public void setUp() {
        player = new Player("Cat");
        go = Space.create("Go","Go");
    }

    @After
    public void teardown() {
        player = null;
        go = null;
    }

    @Test
    public void testLandOnIncreaseBalance() {
        int expectedEndingBalance = player.getCashBalance() + LAND_ON_GO_COLLECT_200;
        go.landOn(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }

    @Test
    public void testPassByIncreaseBalance() {
        int expectedEndingBalance = player.getCashBalance() + LAND_ON_GO_COLLECT_200;
        go.passBy(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }
}
