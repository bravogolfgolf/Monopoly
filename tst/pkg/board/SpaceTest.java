package pkg.board;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pkg.monopoly.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpaceTest {

    private Player player;
    private Space freeParking;
    private DiceMock diceMock;
    private SpaceMockLandOnPassByCounter start;
    private SpaceMockLandOnPassByCounter space1;
    private SpaceMockLandOnPassByCounter space2;
    private Space railroad;
    private Space utility;
    private Space realEstate;

    @Before
    public void setup() {
        player = new Player("Cat");
        freeParking = new FreeParking("Free Parking");
        diceMock = new DiceMock();
        start = new SpaceMockLandOnPassByCounter("Start");
        space1 = new SpaceMockLandOnPassByCounter("Space1");
        space2 = new SpaceMockLandOnPassByCounter("Space2");
        start.setNextSpace(space1);
        space1.setNextSpace(space2);
        space2.setNextSpace(start);
        railroad = new Railroad("Short Line", "Railroad", 200, 25);
        utility = new Utility("Water Works", "Utility", 150);
        realEstate = new RealEstate("Boardwalk", "Blue", 400, 40, 200, 600, 1400, 1700, 2000);
    }

    @After
    public void tearDown() {
        player = null;
        freeParking = null;
        diceMock = null;
        start = null;
        space1 = null;
        space2 = null;
        railroad = null;
        utility = null;
        realEstate = null;
    }

    @Test
    public void testCreateSpace() {
        assertEquals("Short Line", railroad.getDescription());
    }

    @Test
    public void testSetNextSpace() {
        assertTrue(start.getNextSpace().equals(space1));
    }


    @Test
    public void testIsGroup() {
        assertTrue(railroad.isRailroad());
        assertTrue(utility.isUtility());
    }

    @Test
    public void getSourceOfMoveMultiplierBasedOnGroup() {
        SourceOfMoveMultiplier som = new SourceOfMoveMultiplier();
        SourceOfMoveMultiplier som2 = new SourceOfMoveMultiplier(2);
        SourceOfMoveMultiplier som10 = new SourceOfMoveMultiplier(10);
        assertEquals(som.value(), realEstate.getSourceOfMoveMultiplier().value());
        assertEquals(som2.value(), railroad.getSourceOfMoveMultiplier().value());
        assertEquals(som10.value(), utility.getSourceOfMoveMultiplier().value());
    }

    @Test
    public void testLandOnSpaceWithNoChangeInCash() {
        int expectedEndingBalance = player.getCashBalance();
        freeParking.landOn(player, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }

    @Test
    public void testPassBySpaceWithNoChangeInCash() {
        int expectedEndingBalance = player.getCashBalance();
        freeParking.passBy(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }

    @Test
    public void testLandOnMethodCalledProperly() {
        player.setSpace(start);
        player.takeATurn(diceMock);
        assertEquals(0, start.landOnCounter);
        assertEquals(0, space1.landOnCounter);
        assertEquals(1, space2.landOnCounter);
    }

    @Test
    public void testPassByMethodCalledProperly() {
        player.setSpace(start);
        player.takeATurn(diceMock);
        assertEquals(0, start.passByCounter);
        assertEquals(1, space1.passByCounter);
        assertEquals(0, space2.passByCounter);
    }

    @Test
    public void testEqualsAndHashcode() {
        Space railroad1 = new Railroad("Short Line", "Railroad", 200, 25);
        Space utility1 = new Utility("Water Works", "Utility", 150);
        railroad1.setNextSpace(utility1);
        railroad.setNextSpace(utility);
        assertTrue(railroad.equals(railroad1));
        assertTrue(railroad.hashCode() == railroad1.hashCode());
    }
}
