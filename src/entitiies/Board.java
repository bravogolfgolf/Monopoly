package game.entitiies;

import game.interactors.createboard.CreateBoardGateway;

public final class Board implements CreateBoardGateway {
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

    @Override
    public boolean isAvailable(String version) {
        return boardFactory.isAvailable(version);
    }

    private void setVersion(String version) {
        this.version = version;
    }

}