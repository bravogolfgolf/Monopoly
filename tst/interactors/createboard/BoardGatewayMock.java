package game.interactors.createboard;

import game.interactors.BoardGateway;

public class BoardGatewayMock implements BoardGateway {

    public boolean verifyCreateMethodCalled = false;
    public boolean getAvailableBoardsCalled = false;

    @Override
    public void create(String version) {
        verifyCreateMethodCalled = true;
    }

    @Override
    public String[] getAvailableBoards() {
        getAvailableBoardsCalled = true;
        return new String[0];
    }

}
