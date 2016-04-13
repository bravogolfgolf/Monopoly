package game.controllers.setupgame;

import game.interactors.setupgame.SetupGameFactory;

class SetupGameFactoryDummy implements SetupGameFactory {
    @Override
    public void make(String version) {
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
