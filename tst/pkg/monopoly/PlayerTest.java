package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pkg.board.domain.*;
import pkg.card.domain.GetOutOfJail;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

    private static final int PRICE_OF_BOARDWALK = 400;
    private static final int PASS_GO = 200;
    private static final int PRICE_OF_CONNECTICUT_AVENUE = 120;
    private Game game;
    private MonopolyBoard monopolyBoard;
    private Player player1;
    private Player player2;
    private DiceMock diceMock;
    private SpaceMockLandOnPassByCounter start;
    private SpaceMockLandOnPassByCounter space1;
    private SpaceMockLandOnPassByCounter space2;

    @Before
    public void setup() throws IOException {
        game = new Game();
        monopolyBoard = new MonopolyBoard("US", new SpaceFactoryFake());
        player1 = new Player("Cat");
        player2 = new Player("Dog");
        diceMock = new DiceMock();
        mockSpaceSetUp();
    }

    private void mockSpaceSetUp() {
        start = new SpaceMockLandOnPassByCounter("Start");
        space1 = new SpaceMockLandOnPassByCounter("Space1");
        space2 = new SpaceMockLandOnPassByCounter("Space2");
        start.setNextSpace(space1);
        space1.setNextSpace(space2);
        space2.setNextSpace(start);
    }

    @After
    public void tearDown() {
        game = null;
        monopolyBoard = null;
        player1 = null;
        diceMock = null;
        start = null;
        space1 = null;
        space2 = null;
    }

    @Test
    public void testCreatePlayer() {
        final int EXPECTED_INITIAL_CASH_BALANCE = 1500;
        player1.setNextPlayer(player2);
        assertEquals("Cat", player1.getDescription());
        assertEquals(EXPECTED_INITIAL_CASH_BALANCE, player1.getCashBalance());
        assertTrue(player1.getNextPlayer().equals(player2));
    }

    @Test
    public void testMovesAndDoesNoWrap() {
        player1.setSpace(start);
        player1.takeATurn(diceMock);
        Space endingLocation = space2;
        assertTrue(endingLocation.equals(player1.getSpace()));
        assertEquals(0, player1.getNumberOfRolls());
    }

    @Test
    public void testMovesAndWraps() {
        player1.setSpace(space1);
        player1.takeATurn(diceMock);
        Space endingLocation = start;
        assertTrue(endingLocation.equals(player1.getSpace()));
        assertEquals(0, player1.getNumberOfRolls());
    }

    @Test
    public void testIncreaseCashBalance() {
        int expectedBalance = player1.getCashBalance() + 100;
        int expectedNetWorth = player1.getNetWorth() + 100;
        player1.transaction(100, 100, Player.TransactionType.CASH);
        assertEquals(expectedBalance, player1.getCashBalance());
        assertEquals(expectedNetWorth, player1.getNetWorth());
    }

    @Test
    public void testTransactions() {
        assertEquals(1500, player1.getCashBalance());
        assertEquals(1500, player1.getNetWorth());

        player1.transaction(-1400, -1400, Player.TransactionType.CASH);
        assertEquals(100, player1.getCashBalance());
        assertEquals(100, player1.getNetWorth());

        player1.transaction(-100, 50, Player.TransactionType.PURCHASE);
        assertEquals(0, player1.getCashBalance());
        assertEquals(50, player1.getNetWorth());

        player1.transaction(50, 0, Player.TransactionType.MORTGAGE);
        assertEquals(50, player1.getCashBalance());
        assertEquals(50, player1.getNetWorth());

        player1.transaction(60, 60, Player.TransactionType.CASH);
        assertEquals(110, player1.getCashBalance());
        assertEquals(110, player1.getNetWorth());

        player1.transaction(-110, 100, Player.TransactionType.UNMORTGAGE);
        assertEquals(0, player1.getCashBalance());
        assertEquals(100, player1.getNetWorth());
    }

    @Test
    public void testPlayerRollsDoublesThenNot() {
        Dice diceMock = new DiceMockRollsDouble3sThenPlain4();
        playerInitialization();
        Property property1 = (Property) monopolyBoard.getSpace(6);
        Jail property2 = (Jail) monopolyBoard.getSpace(10);

        assertFalse(player1.getSpace().getDescription().equals(property2.getDescription()));
        assertTrue(property1.getOwner().isBank());

        player1.takeATurn(diceMock);

        assertTrue(player1.getSpace().getDescription().equals(property2.getDescription()));
        assertTrue(property1.getOwner().equals(player1));
        assertEquals(0, player1.getNumberOfRolls());
    }

    @Test
    public void testPlayerRollsDoublesTwiceThenNot() {
        Dice diceMock = new DiceMockRollsDoubleTwiceThenNot();
        playerInitialization();

        Property vermontAve = (Property) monopolyBoard.getSpace(8);
        assertTrue(vermontAve.getOwner().isBank());
        Property tennesseeAve = (Property) monopolyBoard.getSpace(18);
        assertTrue(tennesseeAve.getOwner().isBank());
        Property atlanticAve = (Property) monopolyBoard.getSpace(26);
        assertTrue(atlanticAve.getOwner().isBank());

        player1.takeATurn(diceMock);

        assertTrue(vermontAve.getOwner().equals(player1));
        assertTrue(tennesseeAve.getOwner().equals(player1));
        assertTrue(atlanticAve.getOwner().equals(player1));
        assertEquals(0, player1.getNumberOfRolls());
    }

    private void playerInitialization() {
        player1.setSpace(monopolyBoard.getSpace(0));
        player1.resetRollCounter();
    }

    @Test
    public void testPlayerRollsDoublesThreeTimesGoesToJail() {
        int beginningBalance = player1.getCashBalance();
        int beginningNetWorth = player1.getNetWorth();
        Dice diceMock = new DiceMockRollsDoubleThreeTimesInARow();
        player1.setSpace(monopolyBoard.getSpace(35));
        player1.resetRollCounter();

        RealEstate boardwalk = (RealEstate) monopolyBoard.getSpace(39);
        assertTrue(boardwalk.getOwner().isBank());
        int endingBalance = beginningBalance - PRICE_OF_BOARDWALK;
        int endingNetWorth = beginningNetWorth - PRICE_OF_BOARDWALK + (PRICE_OF_BOARDWALK / 2);

        endingBalance = endingBalance + PASS_GO;
        endingNetWorth = endingNetWorth + PASS_GO;

        Property connecticut = (Property) monopolyBoard.getSpace(9);
        assertTrue(connecticut.getOwner().isBank());
        endingBalance = endingBalance - PRICE_OF_CONNECTICUT_AVENUE;
        endingNetWorth = endingNetWorth - PRICE_OF_CONNECTICUT_AVENUE + (PRICE_OF_CONNECTICUT_AVENUE / 2);

        Jail jail = (Jail) monopolyBoard.getSpace(10);
        assertTrue(jail.getDescription().equals("Just Visiting/Jail"));

        game.addPlayer(player1);
        game.play(diceMock);
        assertTrue(boardwalk.getOwner().equals(player1));
        assertTrue(connecticut.getOwner().equals(player1));
        assertEquals(endingBalance, player1.getCashBalance());
        assertEquals(endingNetWorth, player1.getNetWorth());
        assertTrue(player1.getSpace().equals(jail));
        assertEquals(0, player1.getNumberOfRolls());
    }

    @Test
    public void testPlayerRollsDoublesAndLandsOnGoesToJail() {
        int beginningBalance = player1.getCashBalance();
        Dice diceMock = new DiceMockRollsDoubleThreeTimesInARow();
        player1.setSpace(monopolyBoard.getSpace(26));
        player1.resetRollCounter();

        Jail jail = (Jail) monopolyBoard.getSpace(10);
        assertTrue(jail.getDescription().equals("Just Visiting/Jail"));

        game.addPlayer(player1);
        game.play(diceMock);
        assertEquals(beginningBalance, player1.getCashBalance());
        assertTrue(player1.getSpace().equals(jail));
        assertEquals(0, player1.getNumberOfRolls());
    }

    @Test
    public void testPlayerIsInJail() {
        assertFalse(player1.isInJail());
        player1.setInJail(true);
        assertTrue(player1.isInJail());
    }

    @Test
    public void testPostBail() {
        Jail jail = (Jail) monopolyBoard.getSpace(10);
        player1.setSpace(jail);
        player1.setInJail(true);
        assertEquals(1500, player1.getCashBalance());
        assertTrue(player1.isInJail());
        player1.postBail();
        assertEquals(1450, player1.getCashBalance());
        assertFalse(player1.isInJail());
        assertEquals(0, player1.getNumberOfRolls());
    }

    @Test
    public void testAddGetOutOfJailCard() {
        GetOutOfJail getOutOfJail = new GetOutOfJail("Get out of Jail Free – This card may be kept until needed or sold");
        player1.addCard(getOutOfJail);
        assertTrue(getOutOfJail.equals(player1.getCard()));
    }

    @Test
    public void testAddGetOutOfJailCards() {
        GetOutOfJail getOutOfJail1 = new GetOutOfJail("Get out of Jail Free – This card may be kept until needed or sold");
        GetOutOfJail getOutOfJail2 = new GetOutOfJail("Get out of Jail Free – This card may be kept until needed or sold");
        player1.addCard(getOutOfJail1);
        player1.addCard(getOutOfJail2);
        assertTrue(getOutOfJail1.equals(player1.getCard()));
        assertTrue(getOutOfJail2.equals(player1.getCard()));
    }

    @Test
    public void testPlayerHashcode() {
        Player player2 = new Player("Cat");
        assertEquals(player1.hashCode(), player2.hashCode());
    }
}
