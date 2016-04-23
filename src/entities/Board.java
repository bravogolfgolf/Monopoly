package game.entities;

import java.util.List;

public class Board {

    private final List<Space> board;

    public Board(List<Space> board) {
        this.board = board;
    }

    public static class Space {

        private final String description;

        private Space(String description) {
            this.description = description;
        }

        public static class Go extends Space {
            public Go(String description) {
                super(description);
            }
        }

        public static class JustVisiting extends Space {
            public JustVisiting(String description) {
                super(description);
            }
        }

        public static class FreeParking extends Space {
            public FreeParking(String description) {
                super(description);
            }
        }

        public static class GoToJail extends Space {
            public GoToJail(String description) {
                super(description);
            }
        }

        public static class RealEstate extends Space {
            public RealEstate(String description) {
                super(description);
            }
        }

        public static class Railroad extends Space {
            public Railroad(String description) {
                super(description);
            }
        }

        public static class Utility extends Space {
            public Utility(String description) {
                super(description);
            }
        }

        public static class CommunityChest extends Space {
            public CommunityChest(String description) {
                super(description);
            }
        }

        public static class Chance extends Space {
            public Chance(String description) {
                super(description);
            }
        }

        public static class IncomeTax extends Space {
            public IncomeTax(String description) {
                super(description);
            }
        }

        public static class LuxuryTax extends Space {
            public LuxuryTax(String description) {
                super(description);
            }
        }
    }
}