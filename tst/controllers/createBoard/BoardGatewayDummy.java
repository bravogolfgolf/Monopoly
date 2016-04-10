package controllers.createBoard;

import interactors.BoardGateway;

public class BoardGatewayDummy implements BoardGateway {
    @Override
    public void setVersion(String version) {

    }

    @Override
    public String getVersion() {
        return null;
    }
}
