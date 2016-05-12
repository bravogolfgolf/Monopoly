package game.entities;

import game.interactors.movetoken.MoveTokenBoardGateway;
import game.interactors.passgo.PassGoBoardGateway;
import game.interactors.tokenoptions.TokenOptionsBoardGateway;

import java.util.List;

public class Board implements TokenOptionsBoardGateway, PassGoBoardGateway, MoveTokenBoardGateway {

    private final List<Space> board;

    protected Board(List<Space> board) {
        this.board = board;
    }

    public static Board create(List<Space> spaces) {
        for (int i = 1; i < spaces.size(); i++)
            spaces.get(i - 1).setNextSpace(spaces.get(i));
        spaces.get(39).setNextSpace(spaces.get(0));
        return new Board(spaces);
    }

    @Override
    public void move(Token token, int forward) {
        Space space = token.getSpace().nextSpace;
        for (int i = 1; i < forward; i++) {
            space.passedGO(token);
            space = space.nextSpace;
        }
        token.setSpace(space);
    }

    @Override
    public void setInitialSpace(Token token) {
        token.setSpace(board.get(0));
    }

    @Override
    public String getInitialSpaceDescription() {
        return board.get(0).getDescription();
    }

    public abstract static class Space {

        private final int spaceID;
        private final String description;
        private Space nextSpace;

        private Space(int spaceID, String description) {
            this.spaceID = spaceID;
            this.description = description;
        }

        public int getSpaceID() {
            return spaceID;
        }

        public String getDescription() {
            return description;
        }

        private void setNextSpace(Space nextSpace) {
            this.nextSpace = nextSpace;
        }

        protected void passedGO(Token token) {
        }

        public static class Go extends Space {

            public Go(int ID, String description) {
                super(ID, description);
            }

            @Override
            public void passedGO(Token token) {
                token.turnState.passedGO = true;
            }
        }

        public static class JustVisiting extends Space {
            public JustVisiting(int ID, String description) {
                super(ID, description);
            }
        }

        public static class FreeParking extends Space {
            public FreeParking(int ID, String description) {
                super(ID, description);
            }
        }

        public static class GoToJail extends Space {
            public GoToJail(int ID, String description) {
                super(ID, description);
            }
        }

        public static class RealEstate extends Space {
            public RealEstate(int ID, String description) {
                super(ID, description);
            }
        }

        public static class Railroad extends Space {
            public Railroad(int ID, String description) {
                super(ID, description);
            }
        }

        public static class Utility extends Space {
            public Utility(int ID, String description) {
                super(ID, description);
            }
        }

        public static class CommunityChest extends Space {
            public CommunityChest(int ID, String description) {
                super(ID, description);
            }
        }

        public static class Chance extends Space {
            public Chance(int ID, String description) {
                super(ID, description);
            }
        }

        public static class IncomeTax extends Space {
            public IncomeTax(int ID, String description) {
                super(ID, description);
            }
        }

        public static class LuxuryTax extends Space {
            public LuxuryTax(int ID, String description) {
                super(ID, description);
            }
        }
    }
}