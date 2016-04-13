package game.controllers.setupgame;

import game.interactors.setupgame.SetupGameGateway;

class SetupGameGatewayDummy implements SetupGameGateway {
    @Override
    public void create(String version) {
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
