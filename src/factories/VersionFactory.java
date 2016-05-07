package game.factories;

import game.entities.Board;
import game.interactors.versionoptions.VersionOptionsVersionFactory;
import game.repositories.Tokens;

import java.util.Arrays;

import static game.Context.board;
import static game.Context.tokens;

public class VersionFactory implements VersionOptionsVersionFactory {

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
                board = Board.create(SpacesUSA.create());
                tokens = new Tokens(TokensUSA.create());
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
