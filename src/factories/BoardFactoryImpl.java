package game.factories;

import game.entitiies.BoardFactory;

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
        return new String[]{"USA"};
    }
}
