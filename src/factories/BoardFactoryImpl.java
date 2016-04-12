package game.factories;

import game.entitiies.BoardFactory;

import java.util.Arrays;

public class BoardFactoryImpl implements BoardFactory {

    @Override
    public String make(String version) {
        if (version.equals("USA")) {
            return version;
        }
        throw new IllegalArgumentException();
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
