package game.entities;

import game.entitiies.Board;
import game.entitiies.BoardFactory;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class BoardTest {

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidBoard() {
        BoardFactory boardFactory = new BoardFactoryImplInValidRequestStub();
        Board board = new Board(boardFactory);
        board.create("TEST");
    }

    @Test
    public void createValidBoard() {
        BoardFactory boardFactory = new BoardFactoryImplValidRequestStub();
        Board board = new Board(boardFactory);
        board.create("USA");
    }

    @Test
    public void testGetAvailableBoards() {
        BoardFactory boardFactory = new BoardFactoryImplValidRequestStub();
        Board board = new Board(boardFactory);
        String[] actual = board.getAvailableBoards();
        String[] expected = {"USA", "FRA"};
        assertTrue(Arrays.toString(expected).equals(Arrays.toString(actual)));
    }

    @Test
    public void testIsAvailable() {
        BoardFactory boardFactory = new BoardFactoryImplValidRequestStub();
        Board board = new Board(boardFactory);
        assertTrue(board.isAvailable("USA"));
    }
}
