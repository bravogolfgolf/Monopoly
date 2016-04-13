package game.factories;

import game.entitiies.Board;
import game.interactors.setupgame.SetupGameFactory;
import org.junit.Before;
import org.junit.Test;

public class SetupGameFactoryTest {

    private SetupGameFactory factory;

    @Before
    public void setUp() {
        SetupGameBoardGateway board = new Board();
        factory = new SetupGameFactoryImpl(board);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBoardFactoryException() {
        factory.make("");
    }

    @Test
    public void testMakeBoard() {
        factory.make("USA");
    }

    @Test
    public void testGetAvailableBoards() {
        factory.getAvailableBoards();
    }

    @Test
    public void testIsAvailable(){
        factory.isAvailable("USA");
    }
}
