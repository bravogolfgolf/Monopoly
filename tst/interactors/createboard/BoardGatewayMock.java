package game.interactors.createboard;

import game.interactors.BoardGateway;

public class BoardGatewayMock implements BoardGateway {

    private String version;

    public boolean VerifyCreateMethodCalled = false;

    @Override
    public void create(String version) {
        VerifyCreateMethodCalled = true;
        this.version = version;
    }

}
