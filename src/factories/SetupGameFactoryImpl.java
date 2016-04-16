package game.factories;

import game.Context;
import game.entitiies.Board;
import game.entitiies.Token;
import game.interactors.setupgame.SetupGameFactory;
import game.repositories.PlayerRepositoryImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SetupGameFactoryImpl implements SetupGameFactory {

    @Override
    public String[] getAvailableVersions() {
        String[] result = new String[]{"USA", "FRA"};
        Arrays.sort(result);
        return result;
    }

    @Override
    public boolean isAvailable(String version) {
        return Arrays.asList(getAvailableVersions()).contains(version);
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

    private List<Token> tokensList() {
        List<Token> tokens = new ArrayList<>();
        String[] tokenDescriptions = new String[]{"Wheelbarrow", "Battleship", "Scottish Terrier", "Top Hat", "Cat", "Thimble", "Boot", "Automobile"};
        for (String token : tokenDescriptions) {
            tokens.add(new Token(token));
        }
        return tokens;
    }
}
