package game.factories;

import game.entities.Board;
import game.interactors.versionoptions.VersionOptionsVersionFactory;
import game.repositories.Tokens;

import java.util.Arrays;

import static game.factories.ControllerFactoryImpl.board;
import static game.factories.ControllerFactoryImpl.tokens;

public class SelectVersionFactoryImpl implements VersionOptionsVersionFactory {

    @Override
    public String[] getAvailableVersions() {
        String[] result = new String[]{"USA"};
        Arrays.sort(result);
        return result;
    }

    @Override
    public void make(String version) {
        switch (version) {
            case "USA":
                board = new Board(SpacesUSA.create());
                tokens = new Tokens(TokensUSA.create());
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
