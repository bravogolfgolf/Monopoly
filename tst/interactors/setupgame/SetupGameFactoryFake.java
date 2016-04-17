package game.interactors.setupgame;

class SetupGameFactoryFake implements SetupGameFactory {

    boolean verifyCreateMethodCalled = false;
    boolean verifyGetAvailableVersionsCalled = false;
    boolean verifyIsAvailableCalled = false;

    @Override
    public void make(String version) {
        verifyCreateMethodCalled = true;
    }

    @Override
    public String[] getAvailableVersions() {
        verifyGetAvailableVersionsCalled = true;
        return new String[0];
    }
}
