package game.factories;

import game.entities.Board;
import game.entities.Token;
import game.interactors.setupgame.SetupGameFactory;
import game.repositories.PlayerRepositoryImpl;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static game.factories.ControllerFactoryImpl.board;
import static game.factories.ControllerFactoryImpl.playerGateway;

class SetupGameFactoryImpl implements SetupGameFactory {

    @Override
    public String[] getAvailableVersions() {
        String[] result = new String[]{"USA", "TEST"};
        Arrays.sort(result);
        return result;
    }

    @Override
    public void make(String version) {
        switch (version) {
            case "USA":
                setup(version);
                break;
            case "TEST":
                setup(version);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void setup(String version) {
        board = new Board(version);
        playerGateway = new PlayerRepositoryImpl(tokensList(version));
    }

    private Set<Token> tokensList(String version) {
        Set<Token> tokens = new LinkedHashSet<>();
        String[] tokenDescriptions = new String[8];

        String[] tokensUSA = new String[]{"Wheelbarrow", "Battleship", "Scottish Terrier", "Top Hat", "Cat", "Thimble", "Boot", "Automobile"};
        String[] tokensTEST = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight"};

        if (version.equals("USA"))
            tokenDescriptions = tokensUSA;
        if (version.equals("TEST"))
            tokenDescriptions = tokensTEST;

        Arrays.sort(tokenDescriptions);
        makeSet(tokens, tokenDescriptions);
        return tokens;
    }

    private void makeSet(Set<Token> tokens, String[] tokenDescriptions) {
        for (String token : tokenDescriptions) {
            tokens.add(new Token(token));
        }
    }
}
