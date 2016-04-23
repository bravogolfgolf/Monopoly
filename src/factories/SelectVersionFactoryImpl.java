package game.factories;

import game.entities.Board;
import game.interactors.setupgame.SelectVersionFactory;
import game.repositories.PlayerRepositoryImpl;

import java.util.Arrays;

import static game.factories.ControllerFactoryImpl.board;
import static game.factories.ControllerFactoryImpl.playerGateway;
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
        board = new Board(version);
        playerGateway = new PlayerRepositoryImpl(tokenSet(version));
    }
}
