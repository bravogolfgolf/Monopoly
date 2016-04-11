package game.controllers.createBoard;

import game.interactors.BoardGateway;

public class BoardGatewayDummy implements BoardGateway {
    @Override
    public void setVersion(String version) {

    }

    @Override
    public String getVersion() {
        return null;
    }
}
