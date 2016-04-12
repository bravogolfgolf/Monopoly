package game.entities;

import game.entitiies.BoardFactory;

public class BoardFactoryImplValidRequestStub implements BoardFactory {
    @Override
    public String make(String version) {
        return "USA";
    }

    @Override
    public String[] getAvailableBoards() {
        return new String[]{"USA", "FRA"};
    }

    @Override
    public boolean isAvailable(String version) {
        return true;
    }
}
