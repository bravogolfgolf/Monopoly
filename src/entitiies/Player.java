package game.entitiies;

public class Player {

    private final Token token;

    public Player(Token token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return token.equals(player.token);
    }

    @Override
    public int hashCode() {
        return token.hashCode();
    }
}
