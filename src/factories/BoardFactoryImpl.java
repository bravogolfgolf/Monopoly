package game.factories;

import game.entitiies.Board;
import game.interactors.BoardFactory;

public class BoardFactoryImpl implements BoardFactory {
    @Override
    public Board make(String version) {
        if (version.equals("USA")) {
            return new Board();
        }
        throw new IllegalArgumentException();
    }
}
