package game.entitiies;

import game.interactors.BoardGateway;

public final class Board implements BoardGateway {
    private final BoardFactory boardFactory;
    private String version;

    public Board(BoardFactory boardFactory) {
        this.boardFactory = boardFactory;
    }

    @Override
    public void create(String version) {
        setVersion(boardFactory.make(version));
    }

    private void setVersion(String version) {
        this.version = version;
    }

}