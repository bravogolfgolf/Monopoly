package pkg.monopoly;

import org.junit.After;
import org.junit.Test;
import pkg.board.Space;
import pkg.board.SpaceFactory;
import pkg.board.Go;
import pkg.board.Jail;
import pkg.board.Utility;
import pkg.board.FreeParking;
import pkg.board.RealEstate;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {

    private static final int EXPECTED_NUMBER_OF_PLAYERS = 2;
    private Go go;
    private Jail jail;
    private Utility electric;

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

    private Game gameSetup() throws IOException {
        Game game = new Game("US");
        go = (Go) game.getBoard().get(0);
        jail = (Jail) game.getBoard().get(10);
        electric = (Utility) game.getBoard().get(12);
        return game;
    }

    @Test(expected = Game.InvalidPlayerCount.class)
    public void testGameThrowsExceptionWhenFewerThanTwoPlayers() throws Game.InvalidPlayerCount, IOException {
        Game game = gameSetup();
        addThisManyPlayers(1, game);
        game.start();
    }

    @Test
    public void testGameWithTwoPlayers() throws Game.InvalidPlayerCount, IOException {
        Game game = new Game("US");
        for (int i = 0; i < 2; i++) {
            Player player = new Player("Cat");
            player.setSpace(game.getBoard().get(0));
            game.addPlayer(player);
        }
        game.start();
        assertEquals(EXPECTED_NUMBER_OF_PLAYERS, game.getNumberOfPlayers());
    }

    @Test(expected = Game.InvalidPlayerCount.class)
    public void testGameThrowsExceptionWhenMoreThanEightPlayers() throws Game.InvalidPlayerCount, IOException {
        Game game = gameSetup();
        addThisManyPlayers(9, game);
        game.start();
    }

    @Test
    public void testPlayersAreNotAlwaysInSameOrder() throws IOException {

        boolean catBoot = false;
        boolean bootCat = false;

        for (int i = 0; i < 100; i++) {
            Game gameTest = new Game("TEST");
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
        Game game = gameSetup();
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
        Game game = gameSetup();
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
        Game game = gameSetup();
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
        Game game = gameSetup();
        DiceMockRollsDouble3sThenPlain4 dice = new DiceMockRollsDouble3sThenPlain4();
        setUpPlayerMockManagePropertiesCounter(game, go);
        game.play(dice);
        checkPropertiesManageCounts(game, 3, 2);
    }

    @Test
    public void testGameCountManagePropertiesWithDoublesRolledTwice() throws Game.InvalidPlayerCount, IOException {
        Game game = gameSetup();
        DiceMockRollsDoubleTwiceThenNot dice = new DiceMockRollsDoubleTwiceThenNot();
        setUpPlayerMockManagePropertiesCounter(game, go);
        game.play(dice);
        checkPropertiesManageCounts(game, 4, 2);
    }

    @Test
    public void testGameCountManagePropertiesWithDoublesRolledThreeTimes() throws Game.InvalidPlayerCount, IOException {
        Game game = gameSetup();
        DiceMockRollsDoubleThreeTimesInARow dice = new DiceMockRollsDoubleThreeTimesInARow();
        setUpPlayerMockManagePropertiesCounter(game, go);
        game.play(dice);
        checkPropertiesManageCounts(game, 3, 2);
    }

    @Test
    public void testInJailThreeRollsNoDoublesPays50() throws Game.InvalidPlayerCount, IOException {
        Game game = gameSetup();
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
        Game game = gameSetup();
        DiceMockRollsDoubleThreeTimesInARow dice = new DiceMockRollsDoubleThreeTimesInARow();
        setUpPlayerMockManagePropertiesCounter(game, go);

        PlayerMockManagePropertiesCounter player1 = (PlayerMockManagePropertiesCounter) game.getPlayer(0);
        PlayerMockManagePropertiesCounter player2 = (PlayerMockManagePropertiesCounter) game.getPlayer(1);
        player1.setSpace(jail);
        player1.setInJail(true);

        RealEstate virginiaAvenue = (RealEstate) game.getBoard().get(14);
        RealEstate marvinGardens = (RealEstate) game.getBoard().get(29);

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
        Game game = gameSetup();
        DiceMockRollsDouble3sThenPlain4 dice = new DiceMockRollsDouble3sThenPlain4();
        setUpPlayerMockManagePropertiesCounter(game, go);
        PlayerMockManagePropertiesCounter player = (PlayerMockManagePropertiesCounter) game.getPlayer(0);
        player.setSpace(jail);
        player.setInJail(true);
        player.postBail();

        FreeParking freeParking = (FreeParking) game.getBoard().get(20);

        game.play(dice);
        assertEquals(3, player.manageProperties);
        assertTrue(freeParking.equals(player.getSpace()));
        assertEquals(0, player.getNumberOfRolls());
    }

    @Test
    public void testInJailRollsDoubleOnThirdRollMovesNoNextTurn() throws Game.InvalidPlayerCount, IOException {
        Game game = gameSetup();
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
        RealEstate stJamesPlace = (RealEstate) game.getBoard().get(16);
        game.play(newDice);

        assertEquals(6, player.manageProperties);
        assertEquals(0, player.getNumberOfRolls());
        assertTrue(stJamesPlace.equals(player.getSpace()));
        assertFalse(player.isInJail());
    }

    @Test
    public void testCreateBoard() throws IOException {
        Game gameTest = new Game("TEST");
        List<Space> expected = createExpected();
        List<Space> actual = gameTest.getBoard();
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getClass(), actual.get(i).getClass());
            assertEquals(expected.get(i).getDescription(), actual.get(i).getDescription());
            assertEquals(expected.get(i).getNextSpace().getClass(),
                    actual.get(i).getNextSpace().getClass());
            assertEquals(expected.get(i).getNextSpace().getDescription(),
                    actual.get(i).getNextSpace().getDescription());
        }
    }

    private List<Space> createExpected() {
        List<Space> expected = new ArrayList<>();
        Space first = SpaceFactory.create("FreeParking", "Description");
        Space second = SpaceFactory.create("RealEstate", "Description", "Group", 78, 3, -1, -2, -3, -4, -5);
        first.setNextSpace(second);
        second.setNextSpace(first);
        expected.add(first);
        expected.add(second);
        return expected;
    }

}
