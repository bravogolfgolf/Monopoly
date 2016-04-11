package game.factories;

import game.entitiies.Board;
import org.junit.Before;
import org.junit.Test;

import static game.Monopoly.boardFactory;

public class BoardFactoryTest {

    private Board board;

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
