package factories;

import entitiies.Board;
import usecases.createboard.BoardFactory;

public class BoardFactoryImpl implements BoardFactory {
    @Override
    public Board make(String version) {
        return new Board(version);
    }
}
