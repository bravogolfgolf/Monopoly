package game.interactors.createboard;

class CreateBoardGatewayMock implements CreateBoardGateway {

    boolean verifyCreateMethodCalled = false;
    boolean verifyAvailableBoardsCalled = false;
    boolean verifyIsAvailableCalled = false;

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
