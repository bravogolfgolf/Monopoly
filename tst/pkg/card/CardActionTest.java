package pkg.card;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pkg.board.*;
import pkg.monopoly.Game;
import pkg.monopoly.Player;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CardActionTest {

    private static final int PRICE_OF_ILLINOIS_AVENUE = 240;
    private static final int BANK_ERROR_200 = 200;
    private static final int PASS_GO = 200;
    private static final int NUMBER_ROLLED = 5;
    private static final int TEN_TIMES_NUMBER_ROLLED = NUMBER_ROLLED * 10;
    private static final int TWO_TIMES_NORMAL_RENT = 400;
    private Game game;
    private Board board;
    private CommunityChest communityChest1;
    private CommunityChest communityChest2;
    private Player player1;
    private Player player2;
    private RealEstate mediterranean;
    private RealEstate baltic;
    private Chance chance1;
    private RealEstate illinoisAve;
    private Utility electric;
    private Chance chance2;
    private Railroad reading;
    private Railroad bAndO;
    private Railroad penn;
    private Railroad shortLine;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        board = new Board("US", new SpaceFactoryFake());
        communityChest1 = (CommunityChest) board.getSpace(2);
        communityChest2 = (CommunityChest) board.getSpace(33);
        chance1 = (Chance) board.getSpace(36);
        player1 = new Player("Cat");
        player1.setSpace(communityChest1);
        player2 = new Player("Dog");
        player2.setSpace(chance1);
        mediterranean = (RealEstate) board.getSpace(1);
        baltic = (RealEstate) board.getSpace(3);
        illinoisAve = (RealEstate) board.getSpace(24);
        electric = (Utility) board.getSpace(12);
        chance2 = (Chance) board.getSpace(22);
        reading = (Railroad) board.getSpace(5);
        penn = (Railroad) board.getSpace(15);
        bAndO = (Railroad) board.getSpace(25);
        shortLine = (Railroad) board.getSpace(35);
    }

    @After
    public void teardown() {
        game = null;
        board = null;
        communityChest1 = null;
        communityChest2 = null;
        chance1 = null;
        player1 = null;
        player2 = null;
        mediterranean = null;
        baltic = null;
        illinoisAve = null;
        electric = null;
        chance2 = null;
        reading = null;
        penn = null;
        bAndO = null;
        shortLine = null;
    }

    @Test
    public void testGetOutOfJailCardAction() {
        Card getOutOfJail = DeckFactory.create("Get out of Jail Free – This card may be kept until needed or sold", "GetOutOfJail");
        createCommunityChestCard(getOutOfJail);
        assertTrue(player1.getSpace().equals(communityChest1));
        int endingBalance = player1.getCashBalance();
        getOutOfJail.action(player1);
        assertTrue(player1.getSpace().equals(communityChest1));
        assertEquals(endingBalance, player1.getCashBalance());
        assertTrue(getOutOfJail.equals(player1.getCard()));
    }

    @Test
    public void testMoveBackCardAction() {
        Card moveBack = DeckFactory.create("Go Back 3 Spaces", "MoveBack");
        createChanceCard(moveBack);
        Card transaction = DeckFactory.create("Bank error in your favor – Collect $200", "Transaction", 200, "Bank");
        createCommunityChestCard(transaction);
        assertTrue(player2.getSpace().equals(chance1));
        int endingBalance = player2.getCashBalance() + BANK_ERROR_200;
        moveBack.action(player2);
        assertTrue(player2.getSpace().equals(communityChest2));
        assertEquals(endingBalance, player2.getCashBalance());
    }

    @Test
    public void testMoveForwardNextCardAction_Utility() {
        Card moveForwardNext = DeckFactory.create("Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.", "MoveForwardNext", "Utility");
        createChanceCard(moveForwardNext);

        electric.setNumberRolled(NUMBER_ROLLED);

        electric.setOwner(player1);
        assertTrue(player2.getSpace().equals(chance1));
        int player1EndingBalance = player1.getCashBalance() + TEN_TIMES_NUMBER_ROLLED;
        int player2EndingBalance = player2.getCashBalance() + PASS_GO - TEN_TIMES_NUMBER_ROLLED;

        moveForwardNext.action(player2);

        assertEquals(player1EndingBalance, player1.getCashBalance());
        assertEquals(player2EndingBalance, player2.getCashBalance());
        assertTrue(player2.getSpace().equals(electric));
    }

    @Test
    public void testMoveForwardNextCardAction_Railroad() {
        Card moveForwardNext = DeckFactory.create("Advance token to the nearest Railroad and pay owner twice the rental to which he is otherwise entitled. If Railroad is unowned, you may buy it from the Bank", "MoveForwardNext", "Railroad");
        createChanceCard(moveForwardNext);
        reading.setOwner(player1);
        penn.setOwner(player1);
        bAndO.setOwner(player1);
        shortLine.setOwner(player1);
        player2.setSpace(chance2);
        assertTrue(player2.getSpace().equals(chance2));

        int player1EndingBalance = player1.getCashBalance() + TWO_TIMES_NORMAL_RENT;
        int player2EndingBalance = player2.getCashBalance() - TWO_TIMES_NORMAL_RENT;

        moveForwardNext.action(player2);

        assertTrue(player2.getSpace().equals(bAndO));
        assertEquals(player1EndingBalance, player1.getCashBalance());
        assertEquals(player2EndingBalance, player2.getCashBalance());
    }

    @Test
    public void testMoveForwardSpecificCardAction() {
        Card moveForwardSpecific = DeckFactory.create("Advance to Illinois Ave. - If you pass Go, collect $200", "MoveForwardSpecific", "Illinois Avenue");
        createChanceCard(moveForwardSpecific);
        assertTrue(player2.getSpace().equals(chance1));
        int endingBalance = player2.getCashBalance() + PASS_GO;
        int endingNetWorth = player2.getNetWorth() + PASS_GO;

        endingBalance -= PRICE_OF_ILLINOIS_AVENUE;
        endingNetWorth += -PRICE_OF_ILLINOIS_AVENUE + (PRICE_OF_ILLINOIS_AVENUE / 2);
        moveForwardSpecific.action(player2);
        assertTrue(player2.getSpace().equals(illinoisAve));
        assertEquals(endingBalance, player2.getCashBalance());
        assertEquals(endingNetWorth, player2.getNetWorth());

    }

    @Test(expected = GoToJail.GoToJailException.class)
    public void testMoveJail() {
        Card goToJail = DeckFactory.create("Go to Jail – Go directly to jail – Do not pass Go – Do not collect $200", "MoveJail", "Go to Jail");
        createCommunityChestCard(goToJail);
        assertTrue(player1.getSpace().equals(communityChest1));
        goToJail.action(player1);
    }

    @Test
    public void testRepairsCardAction() {
        Card repairs = DeckFactory.create("You are assessed for street repairs – $40 per house – $115 per hotel", "Repairs", 40, 115);
        createCommunityChestCard(repairs);

        int endingBalance = player1.getCashBalance() - ((40 * 4) + 115);
        assertTrue(player1.getSpace().equals(communityChest1));
        mediterranean.setOwner(player1);
        baltic.setOwner(player1);
        addFourHouses(mediterranean);
        addHotel(baltic);
        repairs.action(player1);
        assertTrue(player1.getSpace().equals(communityChest1));
        assertEquals(endingBalance, player1.getCashBalance());
    }

    private void addHotel(RealEstate realEstate) {
        realEstate.addImprovements();
        realEstate.addImprovements();
        realEstate.addImprovements();
        realEstate.addImprovements();
        realEstate.addImprovements();
    }

    private void addFourHouses(RealEstate realEstate) {
        realEstate.addImprovements();
        realEstate.addImprovements();
        realEstate.addImprovements();
        realEstate.addImprovements();
    }

    @Test
    public void testLandOnDrawsTransactionCardForBank() {
        Card transaction = DeckFactory.create("Bank error in your favor – Collect $200", "Transaction", 200, "Bank");
        createCommunityChestCard(transaction);
        assertTrue(player1.getSpace().equals(communityChest1));
        int endingBalance = player1.getCashBalance() + BANK_ERROR_200;
        assertEquals(1, Deck.getCommunityChestCards().size());
        transaction.action(player1);
        assertTrue(player1.getSpace().equals(communityChest1));
        assertEquals(endingBalance, player1.getCashBalance());
        assertEquals(1, Deck.getCommunityChestCards().size());
    }

    @Test
    public void testTransactionCardActionForPlayers() {
        Player player3 = new Player("Ship");

        player1.setNextPlayer(player2);
        player2.setNextPlayer(player3);
        player3.setNextPlayer(player1);

        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);

        Card transaction = DeckFactory.create("Grand Opera Night – Collect $50 from every player for opening night seats", "Transaction", 50, "Players");
        createCommunityChestCard(transaction);

        assertTrue(player1.getSpace().equals(communityChest1));
        int player1EndingBalance = player1.getCashBalance() + 100;
        int player2EndingBalance = player2.getCashBalance() - 50;
        int player3EndingBalance = player3.getCashBalance() - 50;

        transaction.action(player1);
        assertTrue(player1.getSpace().equals(communityChest1));
        assertEquals(player1EndingBalance, player1.getCashBalance());
        assertEquals(player2EndingBalance, player2.getCashBalance());
        assertEquals(player3EndingBalance, player3.getCashBalance());
    }

    private void createCommunityChestCard(Card card) {
        List<Card> cards = new ArrayList<>();
        cards.add(card);
        Deck.addCommunityChestCards(cards);
    }

    private void createChanceCard(Card card) {
        List<Card> cards = new ArrayList<>();
        cards.add(card);
        Deck.addChanceCards(cards);
    }
}
