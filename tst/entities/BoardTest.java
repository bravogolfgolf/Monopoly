package game.entities;

import game.entities.Board.Space;
import game.factories.SpacesUSA;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    private static final int SPACE_ID = 0;
    private static final int FORWARD = 3;
    private final Board board = Board.create(SpacesUSA.create());

    @Test
    public void testMove() {
        Space expected = new Space.RealEstate(3, "Baltic Avenue");
        Space actual = board.move(SPACE_ID, FORWARD);
        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getSpaceID(),actual.getSpaceID());
    }
}