package game.factories;

import game.entities.Board;
import game.interactors.selectversion.SelectVersionFactory;
import game.interactors.versionoptions.VersionOptionsFactory;
import game.repositories.Tokens;

import java.util.Arrays;

import static game.factories.ControllerFactoryImpl.board;
import static game.factories.ControllerFactoryImpl.tokens;

public class SelectVersionFactoryImpl implements SelectVersionFactory, VersionOptionsFactory {

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
                board = new Board(SpacesUSA.create());
                tokens = new Tokens(TokensUSA.create());
                break;
            case "TEST":
                board = new Board(SpacesTEST.create());
                tokens = new Tokens(TokensTEST.create());
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
