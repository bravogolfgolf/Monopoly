package game.factories;

import game.entitiies.BoardFactory;
import org.junit.Before;
import org.junit.Test;

public class BoardFactoryTest {

    private BoardFactory boardFactory;
    @SuppressWarnings("unused")
    private String board;

    @Before
    public void setUp() throws Exception {
        boardFactory = new BoardFactoryImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBoardFactoryException() {
        board = boardFactory.make("");
    }

    @Test
    public void testMakeBoard() {
        board = boardFactory.make("USA");
    }
}
