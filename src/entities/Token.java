package game.entities;

public class Token implements Comparable {

    private static final int INITIAL_STARTING_SPACE_ID = 0;
    private final String description;
    private int spaceID = INITIAL_STARTING_SPACE_ID;

    public Token(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Object o) {
        return this.description.compareTo(((Token) o).description);
    }

    public int getSpaceID() {
        return spaceID;
    }

    public void setSpaceID(int spaceID) {
        this.spaceID = spaceID;
    }
}
