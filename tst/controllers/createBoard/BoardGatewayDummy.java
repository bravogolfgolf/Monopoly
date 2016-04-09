package controllers.createBoard;

import main.BoardGateway;

public class BoardGatewayDummy extends BoardGateway {
    @Override
    public void setVersion(String version) {

    }

    @Override
    public String getVersion() {
        return null;
    }
}
