package game.entities;

public class Token {

    private final String description;

    public Token(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token = (Token) o;

        return description.equals(token.description);

    }

    @Override
    public int hashCode() {
        return description.hashCode();
    }
}
