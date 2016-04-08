package usecases.createboard;

import entitiies.Board;

public interface BoardFactory {
    Board make(String version);
}
