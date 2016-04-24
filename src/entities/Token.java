package game.entities;

public class Token implements Comparable {

    private final String description;

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
}
