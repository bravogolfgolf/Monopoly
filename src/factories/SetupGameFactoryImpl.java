package game.factories;

import game.interactors.setupgame.SetupGameFactory;

import java.util.Arrays;

public class SetupGameFactoryImpl implements SetupGameFactory {

    private final SetupGameBoardGateway board;

    public SetupGameFactoryImpl(SetupGameBoardGateway board) {
        this.board = board;
    }

    @Override
    public void make(String version) {
        switch (version) {
            case "USA":
                board.setVersion("USA");
                break;
            case "FRA":
                board.setVersion("FRA");
                break;
            default:
                throw new IllegalArgumentException();
        }
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
