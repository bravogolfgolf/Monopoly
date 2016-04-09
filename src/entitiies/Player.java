package entitiies;

public class Player {
    private final String token;

    public Player(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
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
