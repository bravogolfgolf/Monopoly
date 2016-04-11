package game.interactors;

import game.entitiies.Board;

public interface BoardFactory {
    Board make(String version);
}
