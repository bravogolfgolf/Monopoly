package game.factories;

import game.entitiies.Board;
import game.interactors.setupgame.SetupGameFactory;

import java.util.Arrays;

public class SetupGameFactoryImpl implements SetupGameFactory {

    private SetupGameBoardGateway board = new Board();

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
    public String[] getAvailableBoards() {
        return new String[]{"USA", "FRA"};
    }

    @Override
    public boolean isAvailable(String version) {
        return Arrays.asList(getAvailableBoards()).contains(version);
    }
}
