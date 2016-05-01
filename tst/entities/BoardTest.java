package game.entities;

import game.doubles.DiceMock;
import game.factories.SpacesTEST;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    private final Board board = new Board(SpacesTEST.create());
    private final Token token = new Token("");
    private final Dice dice = new DiceMock(2, false);

    @Test
    public void testMove() {
        Board.Space expected = new Board.Space.RealEstate("Baltic Avenue");
        Board.Space actual = board.move(token, dice);
        assertEquals(expected.getDescription(), actual.getDescription());
    }
}