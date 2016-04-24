package game.entities;

import game.interactors.createplayer.CreatePlayerGateway;
import game.interactors.options.OptionsPlayerGateway;
import game.interactors.selectfirst.SelectFirstPlayerGateway;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Players implements CreatePlayerGateway, OptionsPlayerGateway, SelectFirstPlayerGateway {

    private final List<Player> players = new LinkedList<>();
    private final Set<Player.Token> tokens;

    public Players(Set<Player.Token> tokens) {
        this.tokens = tokens;
    }

    @Override
    public void create(String request) {
        Player.Token token = new Player.Token(request);
        tokens.remove(token);
        Player player = new Player(token);
        players.add(player);
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

    @Override
    public void randomizePlayers() {
        Collections.shuffle(players);
    }

    @Override
    public String getFirstPlayer() {
        return players.get(0).token.getDescription();
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
            public int compareTo(Object o) {
                return this.description.compareTo(((Token) o).description);
            }
        }
    }
}
