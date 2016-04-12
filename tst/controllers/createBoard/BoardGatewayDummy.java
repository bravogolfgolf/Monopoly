package game.controllers.createBoard;

import game.interactors.BoardGateway;

public class BoardGatewayDummy implements BoardGateway {
    @Override
    public void create(String version) {

    }

    @Override
    public String[] getAvailableBoards() {
        return new String[0];
    }

}
