package game.factories;

import game.Context;
import game.entitiies.Board;
import game.entitiies.Token;
import game.interactors.setupgame.SetupGameFactory;
import game.repositories.PlayerRepositoryImpl;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

class SetupGameFactoryImpl implements SetupGameFactory {

    @Override
    public String[] getAvailableVersions() {
        String[] result = new String[]{"USA", "FRA"};
        Arrays.sort(result);
        return result;
    }

    @Override
    public void make(String version) {
        switch (version) {
            case "USA":
                setupUSA("USA");
                break;
            case "FRA":
                setupFRA("FRA");
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void setupUSA(String version) {
        Context.board = new Board(version);
        Context.playerGateway = new PlayerRepositoryImpl(tokensList());
    }

    private void setupFRA(String version) {
        setupUSA(version);
    }

    private Set<Token> tokensList() {
        Set<Token> tokens = new LinkedHashSet<>();
        String[] tokenDescriptions = new String[]{"Wheelbarrow", "Battleship", "Scottish Terrier", "Top Hat", "Cat", "Thimble", "Boot", "Automobile"};
        Arrays.sort(tokenDescriptions);
        for (String token : tokenDescriptions) {
            tokens.add(new Token(token));
        }
        return tokens;
    }
}
