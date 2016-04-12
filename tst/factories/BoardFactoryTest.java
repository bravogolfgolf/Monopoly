package game.factories;

import game.entitiies.BoardFactory;
import org.junit.Before;
import org.junit.Test;

public class BoardFactoryTest {

    private BoardFactory boardFactory;

    @Before
    public void setUp() {
        boardFactory = new BoardFactoryImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBoardFactoryException() {
        boardFactory.make("");
    }

    @Test
    public void testMakeBoard() {
        boardFactory.make("USA");
    }

    @Test
    public void testGetAvailableBoards() {
        boardFactory.getAvailableBoards();
    }
}
