package game.interactors.createboard;

import game.interactors.BoardGateway;

public class BoardGatewayMock implements BoardGateway {

    public boolean verifyCreateMethodCalled = false;
    public boolean verifyAvailableBoardsCalled = false;
    public boolean verifyIsAvailableCalled = false;

    @Override
    public void create(String version) {
        verifyCreateMethodCalled = true;
    }

    @Override
    public String[] getAvailableBoards() {
        verifyAvailableBoardsCalled = true;
        return new String[0];
    }

    @Override
    public boolean isAvailable(String version) {
        verifyIsAvailableCalled = true;
        return false;
    }
}
