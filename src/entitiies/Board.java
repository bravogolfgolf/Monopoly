package game.entitiies;

import game.interactors.BoardGateway;

public final class Board implements BoardGateway {
    private final BoardFactory boardFactory;
    @SuppressWarnings("unused")
    private String version;

    public Board(BoardFactory boardFactory) {
        this.boardFactory = boardFactory;
    }

    @Override
    public void create(String version) {
        setVersion(boardFactory.make(version));
    }

    @Override
    public String[] getAvailableBoards() {
        return boardFactory.getAvailableBoards();
    }

    private void setVersion(String version) {
        this.version = version;
    }

}