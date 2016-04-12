package game.interactors.createboard;

import game.interactors.BoardGateway;

public class BoardGatewayMock implements BoardGateway {

    public boolean verifyCreateMethodCalled = false;
    public boolean verifyAvailableBoardsCalled = false;

    @Override
    public void create(String version) {
        verifyCreateMethodCalled = true;
    }

    @Override
    public String[] getAvailableBoards() {
        verifyAvailableBoardsCalled = true;
        return new String[0];
    }

}
