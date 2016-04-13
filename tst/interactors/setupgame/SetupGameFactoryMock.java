package game.interactors.setupgame;

class SetupGameFactoryMock implements SetupGameFactory {

    boolean verifyCreateMethodCalled = false;
    boolean verifyAvailableBoardsCalled = false;
    boolean verifyIsAvailableCalled = false;

    @Override
    public void make(String version) {
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
