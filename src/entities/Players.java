package game.entities;

import game.interactors.gamesetup.createplayer.CreatePlayerGateway;

import java.util.HashSet;
import java.util.Set;

public class Players implements CreatePlayerGateway {

    private final Set<Player> players = new HashSet<>();
    private final Set<Player.Token> tokens;

    public Players(Set<Player.Token> tokens) {
        this.tokens = tokens;
    }

    @Override
    public boolean create(String request) {
        Player.Token token = new Player.Token(request);
        tokens.remove(token);
        Player player = new Player(token);
        return players.add(player);
    }

    @Override
    public String[] getAvailableTokens() {
        String[] result = new String[tokens.size()];
        int counter = 0;
        for (Player.Token token : tokens) {
            result[counter++] = token.getDescription();
        }
        return result;
    }

    public static class Player {

        private final Token token;

        Player(Token token) {
            this.token = token;
        }

        public static class Token implements Comparable {

            private final String description;

            public Token(String description) {
                this.description = description;
            }

            String getDescription() {
                return description;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Token)) return false;

                Token token = (Token) o;

                return description.equals(token.description);
            }

            @Override
            public int hashCode() {
                return description.hashCode();
            }

            @Override
            public int compareTo(Object o) {
                return this.description.compareTo(((Token)o).description);
            }
        }
    }
}
