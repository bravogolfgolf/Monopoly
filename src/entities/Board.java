package game.entities;

import game.interactors.movetoken.MoveTokenBoardGateway;

import java.util.List;

public class Board implements MoveTokenBoardGateway {

    private final List<Space> board;

    protected Board(List<Space> board) {
        this.board = board;
    }

    public static Board create(List<Space> spaces){
        return new Board(spaces);
    }

    @Override
    public Board.Space move(int spaceID, int forward) {
        Space startingSpace = findSpaceBy(spaceID + forward);
        return startingSpace;
    }

    private Space findSpaceBy(int spaceID) {
        for (Space space : board) {
            if (space.getSpaceID() == spaceID)
                return space;
        }
        throw new IllegalArgumentException();
    }

    public static class Space {

        private final int spaceID;
        private final String description;

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

        public static class Go extends Space {
            public Go(int ID, String description) {
                super(ID, description);
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