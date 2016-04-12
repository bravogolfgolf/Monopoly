package game.entities;

import game.entitiies.BoardFactory;

public class BoardFactoryImplInValidRequestStub implements BoardFactory {
    @Override
    public String make(String version) {
        throw new IllegalArgumentException();
    }

    @Override
    public String[] getAvailableBoards() {
        return new String[0];
    }

    @Override
    public boolean isAvailable(String version) {
        return false;
    }
}
