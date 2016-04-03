package pkg.game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pkg.board.domain.*;
import pkg.card.domain.Deck;
import pkg.card.domain.DeckFactoryFakeUS;


import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {

    private static final int EXPECTED_NUMBER_OF_PLAYERS = 2;
    private Go go;
    private Jail jail;
    private Utility electric;
    private Game game;
    private Board board;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        board = new MonopolyBoard("US", new SpaceFactoryFake());
        go = (Go) board.getSpace(0);
        jail = (Jail) board.getSpace(10);
        electric = (Utility) board.getSpace(12);
        Deck.create(new DeckFactoryFakeUS(), Deck.DeckType.CHEST,"US");
        Deck.create(new DeckFactoryFakeUS(), Deck.DeckType.CHANCE,"US");
    }

    @After
    public void tearDown() {
        go = null;
        jail = null;
        electric = null;
    }

    private void addThisManyPlayers(int number, Game game) {
        for (int i = 0; i < number; i++) {
            Player player = new Player("Cat");
            game.addPlayer(player);
        }
    }

    @Test(expected = Game.InvalidPlayerCount.class)
    public void testGameThrowsExceptionWhenFewerThanTwoPlayers() throws Game.InvalidPlayerCount, IOException {
        addThisManyPlayers(1, game);
        game.start();
    }

    @Test
    public void testGameWithTwoPlayers() throws Game.InvalidPlayerCount, IOException {
        for (int i = 0; i < 2; i++) {
            Player player = new Player(Integer.toString(i));
            player.setSpace(board.getSpace(0));
            game.addPlayer(player);
        }
        game.start();
        assertEquals(EXPECTED_NUMBER_OF_PLAYERS, game.getNumberOfPlayers());
    }

    @Test(expected = Game.InvalidPlayerCount.class)
    public void testGameThrowsExceptionWhenMoreThanEightPlayers() throws Game.InvalidPlayerCount, IOException {
        addThisManyPlayers(9, game);
        game.start();
    }

    @Test
    public void testPlayersAreNotAlwaysInSameOrder() throws IOException {

        boolean catBoot = false;
        boolean bootCat = false;

        for (int i = 0; i < 100; i++) {
            Game gameTest = new Game();
            Player catPlayer = new Player("Cat");
            Player dogPlayer = new Player("Dog");
            gameTest.addPlayer(catPlayer);
            gameTest.addPlayer(dogPlayer);
            gameTest.randomizePlayerOrder();
            assertEquals(EXPECTED_NUMBER_OF_PLAYERS, gameTest.getNumberOfPlayers());

            if (gameTest.getPlayer(0).equals(catPlayer) && gameTest.getPlayer(1).equals(dogPlayer))
                catBoot = true;

            if (gameTest.getPlayer(0).equals(dogPlayer) && gameTest.getPlayer(1).equals(catPlayer))
                bootCat = true;

            if (catBoot && bootCat)
                break;
        }
        assertTrue(catBoot && bootCat);
    }

    @Test
    public void testGameOfTwentyRoundsCountTurnsTaken() throws Game.InvalidPlayerCount, IOException {
        Dice dice = new Dice();
        for (int i = 0; i < 2; i++) {
            PlayerMockTurnCounter player = new PlayerMockTurnCounter();
            game.addPlayer(player);

        }
        for (int i = 0; i < 20; i++)
            game.play(dice);
        PlayerMockTurnCounter player1 = (PlayerMockTurnCounter) game.getPlayer(0);
        PlayerMockTurnCounter player2 = (PlayerMockTurnCounter) game.getPlayer(1);
        assertEquals(20, player1.turnsTaken);
        assertEquals(20, player2.turnsTaken);
    }

    @Test
    public void testPlayersAlternateOrder() throws Game.InvalidPlayerCount, IOException {
        Dice dice = new Dice();
        PlayerMockAlternateOrder player1 = new PlayerMockAlternateOrder();
        PlayerMockAlternateOrder player2 = new PlayerMockAlternateOrder();
        game.addPlayer(player1);
        game.addPlayer(player2);

        for (int i = 0; i < 20; i++)
            game.play(dice);

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0)
                assertTrue(player1.equals(PlayerMockAlternateOrder.order.get(i)));
            else
                assertTrue(player2.equals(PlayerMockAlternateOrder.order.get(i)));
        }
    }

    @Test
    public void testGameOfTenRoundsCountManageProperties() throws Game.InvalidPlayerCount, IOException {
        DiceMock dice = new DiceMock();
        setUpPlayerMockManagePropertiesCounter(game, go);
        for (int i = 0; i < 10; i++)
            game.play(dice);
        checkPropertiesManageCounts(game, 20, 20);
    }

    private void setUpPlayerMockManagePropertiesCounter(Game game, Space startingSpace) {
        for (int i = 0; i < 2; i++) {
            PlayerMockManagePropertiesCounter player = new PlayerMockManagePropertiesCounter();
            game.addPlayer(player);
            player.setSpace(startingSpace);
        }
    }

    private void checkPropertiesManageCounts(Game game, int player1Expected, int player2Expected) {
        PlayerMockManagePropertiesCounter player1 = (PlayerMockManagePropertiesCounter) game.getPlayer(0);
        PlayerMockManagePropertiesCounter player2 = (PlayerMockManagePropertiesCounter) game.getPlayer(1);
        assertEquals(player1Expected, player1.manageProperties);
        assertEquals(player2Expected, player2.manageProperties);
    }

    @Test
    public void testGameCountManagePropertiesWithDoublesRolled() throws Game.InvalidPlayerCount, IOException {
        DiceMockRollsDouble3sThenPlain4 dice = new DiceMockRollsDouble3sThenPlain4();
        setUpPlayerMockManagePropertiesCounter(game, go);
        game.play(dice);
        checkPropertiesManageCounts(game, 3, 2);
    }

    @Test
    public void testGameCountManagePropertiesWithDoublesRolledTwice() throws Game.InvalidPlayerCount, IOException {
        DiceMockRollsDoubleTwiceThenNot dice = new DiceMockRollsDoubleTwiceThenNot();
        setUpPlayerMockManagePropertiesCounter(game, go);
        game.play(dice);
        checkPropertiesManageCounts(game, 4, 2);
    }

    @Test
    public void testGameCountManagePropertiesWithDoublesRolledThreeTimes() throws Game.InvalidPlayerCount, IOException {
        DiceMockRollsDoubleThreeTimesInARow dice = new DiceMockRollsDoubleThreeTimesInARow();
        setUpPlayerMockManagePropertiesCounter(game, go);
        game.play(dice);
        checkPropertiesManageCounts(game, 3, 2);
    }

    @Test
    public void testInJailThreeRollsNoDoublesPays50() throws Game.InvalidPlayerCount, IOException {
        DiceMock dice = new DiceMock();
        PlayerMockManagePropertiesCounter player = new PlayerMockManagePropertiesCounter();
        player.setInJail(true);
        game.addPlayer(player);
        player.setSpace(jail);

        game.play(dice);
        assertEquals(2, player.manageProperties);
        assertEquals(1, player.getNumberOfRolls());
        assertTrue(jail.equals(player.getSpace()));
        assertTrue(player.isInJail());

        game.play(dice);
        assertEquals(4, player.manageProperties);
        assertEquals(2, player.getNumberOfRolls());
        assertTrue(jail.equals(player.getSpace()));
        assertTrue(player.isInJail());

        game.play(dice);
        assertEquals(6, player.manageProperties);
        assertEquals(0, player.getNumberOfRolls());
        assertTrue(electric.equals(player.getSpace()));
        assertFalse(player.isInJail());
    }

    @Test
    public void testInJailRollsDoubleMovesNoNextTurn() throws Game.InvalidPlayerCount, IOException {
        DiceMockRollsDoubleThreeTimesInARow dice = new DiceMockRollsDoubleThreeTimesInARow();
        setUpPlayerMockManagePropertiesCounter(game, go);

        PlayerMockManagePropertiesCounter player1 = (PlayerMockManagePropertiesCounter) game.getPlayer(0);
        PlayerMockManagePropertiesCounter player2 = (PlayerMockManagePropertiesCounter) game.getPlayer(1);
        player1.setSpace(jail);
        player1.setInJail(true);

        RealEstate virginiaAvenue = (RealEstate) board.getSpace(14);
        RealEstate marvinGardens = (RealEstate) board.getSpace(29);

        game.play(dice);

        checkPropertiesManageCounts(game, 2, 4);
        assertTrue(virginiaAvenue.equals(player1.getSpace()));
        assertEquals(0, player1.getNumberOfRolls());
        assertFalse(player1.isInJail());

        assertTrue(marvinGardens.equals(player2.getSpace()));
        assertEquals(0, player2.getNumberOfRolls());
        assertFalse(player2.isInJail());
    }

    @Test
    public void testInJailPays50RollsDoubleMovesAndNextTurn() throws Game.InvalidPlayerCount, IOException {
        DiceMockRollsDouble3sThenPlain4 dice = new DiceMockRollsDouble3sThenPlain4();
        setUpPlayerMockManagePropertiesCounter(game, go);
        PlayerMockManagePropertiesCounter player = (PlayerMockManagePropertiesCounter) game.getPlayer(0);
        player.setSpace(jail);
        player.setInJail(true);
        player.postBail();

        FreeParking freeParking = (FreeParking) board.getSpace(20);

        game.play(dice);
        assertEquals(3, player.manageProperties);
        assertTrue(freeParking.equals(player.getSpace()));
        assertEquals(0, player.getNumberOfRolls());
    }

    @Test
    public void testInJailRollsDoubleOnThirdRollMovesNoNextTurn() throws Game.InvalidPlayerCount, IOException {
        DiceMock dice = new DiceMock();
        setUpPlayerMockManagePropertiesCounter(game, go);
        PlayerMockManagePropertiesCounter player = (PlayerMockManagePropertiesCounter) game.getPlayer(0);
        player.setSpace(jail);
        player.setInJail(true);

        game.play(dice);

        assertEquals(2, player.manageProperties);
        assertEquals(1, player.getNumberOfRolls());
        assertTrue(jail.equals(player.getSpace()));
        assertTrue(player.isInJail());

        game.play(dice);

        assertEquals(4, player.manageProperties);
        assertEquals(2, player.getNumberOfRolls());
        assertTrue(jail.equals(player.getSpace()));
        assertTrue(player.isInJail());

        DiceMockRollsDouble3sThenPlain4 newDice = new DiceMockRollsDouble3sThenPlain4();
        RealEstate stJamesPlace = (RealEstate) board.getSpace(16);
        game.play(newDice);

        assertEquals(6, player.manageProperties);
        assertEquals(0, player.getNumberOfRolls());
        assertTrue(stJamesPlace.equals(player.getSpace()));
        assertFalse(player.isInJail());
    }
}

