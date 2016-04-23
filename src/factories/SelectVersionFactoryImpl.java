package game.factories;

import game.entities.Board;
import game.entities.Players;
import game.interactors.selectversion.SelectVersionFactory;

import java.util.Arrays;

import static game.factories.ControllerFactoryImpl.board;
import static game.factories.ControllerFactoryImpl.players;
import static game.factories.TokenFactory.tokenSet;

class SelectVersionFactoryImpl implements SelectVersionFactory {

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
        board = new Board(BoardFactory.boardList(version));
        players = new Players(tokenSet(version));
    }
}
