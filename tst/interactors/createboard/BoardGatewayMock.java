package game.interactors.createboard;

import game.interactors.BoardGateway;

public class BoardGatewayMock implements BoardGateway {

    public boolean verifyCreateMethodCalled = false;

    @Override
    public void create(String version) {
        verifyCreateMethodCalled = true;
    }

}
