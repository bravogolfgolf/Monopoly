package game.entities;

import game.entities.Board.Space;
import game.factories.SpacesUSA;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    private static final int NOT_PASS_GO = 3;
    private static final int PASS_GO = 41;
    private static final int LAND_ON_GO = 40;
    private final Token token = new Token("Cat");
    private final Board board = Board.create(SpacesUSA.create());

    @Before
    public void setup() {
        board.setInitialSpace(token);
    }

    @Test
    public void getInitialDescription() {
        assertEquals("GO", board.getInitialSpaceDescription());
    }

    @Test
    public void landOnSpaceWithoutPassingGo() {
        Space expected = new Space.RealEstate(3, "RealEstate");
        token.setMove(NOT_PASS_GO);

        assertEquals(false, board.move(token));
        assertEquals(expected.getSpaceID(), token.getSpace().getSpaceID());
    }

    @Test
    public void landOnSpaceWithPassingGo() {
        Space expected = new Space.RealEstate(1, "RealEstate");
        token.setMove(PASS_GO);
        assertEquals(true, board.move(token));
        assertEquals(expected.getSpaceID(), token.getSpace().getSpaceID());
    }

    @Test
    public void landOnGo() {
        Space expected = new Space.Go(0, "Go");
        token.setMove(LAND_ON_GO);
        assertEquals(false, board.move(token));
        assertEquals(expected.getSpaceID(), token.getSpace().getSpaceID());
    }
}