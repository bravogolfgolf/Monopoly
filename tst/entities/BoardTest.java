package game.entities;

import game.entities.Board.Space;
import game.factories.SpacesUSA;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    private static final int FORWARD = 3;
    private static final int PASS_GO = 41;
    private static final int LAND_ON_GO = 40;
    private final Token token = new Token("Cat");
    private final Board board = Board.create(SpacesUSA.create());

    @Test
    public void landOnSpaceWithoutPassingGo() {
        Space expected = new Space.RealEstate(3, "RealEstate");
        boolean passedGO = board.movesPassedGO(token, FORWARD);
        assertEquals(expected.getSpaceID(), token.getSpaceID());
        assertEquals(false, passedGO);
    }

    @Test
    public void landOnSpaceWithPassingGo() {
        Space expected = new Space.RealEstate(1, "RealEstate");
        boolean passedGO = board.movesPassedGO(token, PASS_GO);
        assertEquals(expected.getSpaceID(), token.getSpaceID());
        assertEquals(true, passedGO);
    }

    @Test
    public void landOnGo() {
        Space expected = new Space.Go(0, "Go");
        boolean passedGO = board.movesPassedGO(token, LAND_ON_GO);
        assertEquals(expected.getSpaceID(), token.getSpaceID());
        assertEquals(false, passedGO);
    }
}