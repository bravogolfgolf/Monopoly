package game.controllers.createBoard;

import game.interactors.createboard.CreateBoardGateway;

class CreateBoardGatewayDummy implements CreateBoardGateway {
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
