package game.factories;

import game.entitiies.Token;
import game.interactors.setupgame.SetupGameFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetupGameFactoryImpl implements SetupGameFactory {

    private final SetupGameBoardGateway board;
    private final SetupGamePlayerGateway player;

    public SetupGameFactoryImpl(SetupGameBoardGateway board, SetupGamePlayerGateway player) {
        this.board = board;
        this.player = player;
    }

    @Override
    public void make(String version) {
        switch (version) {
            case "USA":
                setup("USA");
                break;
            case "FRA":
                setup("FRA");
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void setup(String version) {
        board.setVersion(version);
        player.setTokens(tokensList());
    }

    private List<Token> tokensList() {
        List<Token> tokens = new ArrayList<>();
        String[] tokenDescriptions = new String[]{"Wheelbarrow", "Battleship", "Scottish Terrier", "Top Hat", "Cat", "Thimble", "Boot", "Automobile"};
        for (String token : tokenDescriptions) {
            tokens.add(new Token(token));
        }
        return tokens;
    }

    @Override
    public String[] getAvailableVersions() {
        return new String[]{"USA", "FRA"};
    }

    @Override
    public boolean isAvailable(String version) {
        return Arrays.asList(getAvailableVersions()).contains(version);
    }
}
