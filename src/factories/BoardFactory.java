package factories;

import entitiies.Board;
import usecases.Factory;

public class BoardFactory implements Factory {
    @Override
    public Board make(String version) {
        return new Board(version);
    }
}
