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
    public void setup(){
        token.setSpace(board.findSpaceBy(token.spaceID));
    }

    @Test
    public void landOnSpaceWithoutPassingGo() {
        Space expected = new Space.RealEstate(3, "RealEstate");
        board.move(token, NOT_PASS_GO);
        assertEquals(expected.getSpaceID(), token.getSpace().getSpaceID());
        assertEquals(false, token.turnState.passedGO);
    }

    @Test
    public void landOnSpaceWithPassingGo() {
        Space expected = new Space.RealEstate(1, "RealEstate");
        board.move(token, PASS_GO);
        assertEquals(expected.getSpaceID(), token.getSpace().getSpaceID());
        assertEquals(true, token.turnState.passedGO);
    }

    @Test
    public void landOnGo() {
        Space expected = new Space.Go(0, "Go");
        board.move(token, LAND_ON_GO);
        assertEquals(expected.getSpaceID(), token.getSpace().getSpaceID());
        assertEquals(false, token.turnState.passedGO);
    }
}