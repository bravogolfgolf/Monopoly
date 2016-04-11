package game.interactors.createboard;

import game.interactors.BoardGateway;

public class BoardGatewayMock implements BoardGateway {

    private String version;

    public boolean verifyCreateMethodCalled = false;

    @Override
    public void create(String version) {
        verifyCreateMethodCalled = true;
        this.version = version;
    }

}
