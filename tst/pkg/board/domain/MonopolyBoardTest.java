package pkg.board.domain;

import org.junit.Test;
import pkg.game.Board;
import pkg.game.Player;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MonopolyBoardTest {


    @Test
    public void testGetAllRealEstateOfPlayer() throws IOException {
        Board board = new MonopolyBoard("US", new SpaceFactoryFake());
        Player player = new Player("Cat");
        RealEstate mediterranean = (RealEstate) board.getSpace(1);
        RealEstate baltic = (RealEstate) board.getSpace(3);
        CommunityChest communityChest = (CommunityChest) board.getSpace(2);
        player.setSpace(communityChest);
        mediterranean.setOwner(player);
        baltic.setOwner(player);
        List<RealEstate> realEstateHoldings = Board.getAllRealEstateOf(player);
        assertEquals(2, realEstateHoldings.size());
        assertTrue(baltic.equals(realEstateHoldings.get(0)));
        assertTrue(mediterranean.equals(realEstateHoldings.get(1)));
    }

    @Test
    public void testCreateBoard() throws IOException {
        Board board = new MonopolyBoard("US", new SpaceFactoryFake());
        assertEquals(40, board.size());
        assertEquals("Go", board.getSpace(0).getClass().getSimpleName());
        assertEquals("Go", board.getSpace(0).getDescription());
        assertEquals("RealEstate", board.getSpace(0).getNextSpace().getClass().getSimpleName());
        assertEquals("Mediterranean Avenue", board.getSpace(0).getNextSpace().getDescription());
    }

    @Test
    public void testCreateActualBoard() throws IOException {
        int goCount = 0;
        int communityChestCount = 0;
        int chanceCount = 0;
        int freeParkingCount = 0;
        int jailCount = 0;
        int goToJailCount = 0;
        int incomeTaxCount = 0;
        int luxuryTaxCount = 0;
        int realEstateCount = 0;
        int brownGroupCount = 0;
        int lightBlueGroupCount = 0;
        int purpleGroupCount = 0;
        int orangeGroupCount = 0;
        int redGroupCount = 0;
        int yellowGroupCount = 0;
        int greenGroupCount = 0;
        int blueGroupCount = 0;
        int railroadCount = 0;
        int utilityCount = 0;
        Board board = new MonopolyBoard("US", new SpaceFactoryFake());
        assertTrue(board.size() == 40);
        for (Object obj : board) {
            Space space = (Space) obj;
            String classType = space.getClass().getSimpleName();
            if (classType.equals("Go")) goCount++;
            if (classType.equals("CommunityChest")) communityChestCount++;
            if (classType.equals("Chance")) chanceCount++;
            if (classType.equals("FreeParking")) freeParkingCount++;
            if (classType.equals("Jail")) jailCount++;
            if (classType.equals("GoToJail")) goToJailCount++;
            if (classType.equals("IncomeTax")) incomeTaxCount++;
            if (classType.equals("LuxuryTax")) luxuryTaxCount++;
            if (classType.equals("Railroad")) railroadCount++;
            if (classType.equals("Utility")) utilityCount++;
            if (classType.equals("RealEstate")) {
                realEstateCount++;
                String group = space.getGroup();
                if (group.equals("Brown")) brownGroupCount++;
                if (group.equals("Light Blue")) lightBlueGroupCount++;
                if (group.equals("Purple")) purpleGroupCount++;
                if (group.equals("Orange")) orangeGroupCount++;
                if (group.equals("Red")) redGroupCount++;
                if (group.equals("Yellow")) yellowGroupCount++;
                if (group.equals("Green")) greenGroupCount++;
                if (group.equals("Blue")) blueGroupCount++;
            }
        }
        assertEquals(1, goCount);
        assertEquals(3, communityChestCount);
        assertEquals(3, chanceCount);
        assertEquals(1, freeParkingCount);
        assertEquals(1, jailCount);
        assertEquals(1, goToJailCount);
        assertEquals(1, incomeTaxCount);
        assertEquals(1, luxuryTaxCount);
        assertEquals(4, railroadCount);
        assertEquals(2, utilityCount);

        assertEquals(22, realEstateCount);
        assertEquals(2, brownGroupCount);
        assertEquals(3, lightBlueGroupCount);
        assertEquals(3, purpleGroupCount);
        assertEquals(3, orangeGroupCount);
        assertEquals(3, redGroupCount);
        assertEquals(3, yellowGroupCount);
        assertEquals(3, greenGroupCount);
        assertEquals(2, blueGroupCount);
    }
}
