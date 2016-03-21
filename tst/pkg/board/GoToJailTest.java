package pkg.board;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pkg.board.Go;
import pkg.board.GoToJail;
import pkg.board.Jail;
import pkg.monopoly.OwnershipMultiplier;
import pkg.monopoly.Player;
import pkg.monopoly.SourceOfMoveMultiplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GoToJailTest {

    private Go go;
    private Jail jail;
    private GoToJail goToJail;
    private Player player;
    private int beginningBalance;
    private int endingBalance;

    @Before
    public void setUp() {
        go = new Go("Go");
        jail = new Jail("Just Visiting/Jail");
        goToJail = new GoToJail("Go to Jail");

        go.setNextSpace(jail);
        jail.setNextSpace(goToJail);
        goToJail.setNextSpace(go);

        player = new Player("Cat");
        player.setSpace(go);

        beginningBalance = player.getCashBalance();
        endingBalance = beginningBalance;
    }

    @After
    public void tearDown() {
        go = null;
        jail = null;
        goToJail = null;
        player = null;
    }

    @Test(expected = GoToJail.GoToJailException.class)
    public void testLandOnGoToJailAndPlayerDoesGoToJailWithNoChangeInCash() {
        goToJail.landOn(player, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
    }

    @Test
    public void testPassByGoToJailAndPlayerDoesNotGoToJailWithNoChangeInCash() {
        goToJail.passBy(player);
        assertFalse(player.getSpace().equals(jail));
        assertEquals(beginningBalance,endingBalance);
    }
}