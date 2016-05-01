package game.doubles;

import game.factories.SelectVersionFactoryImpl;

public class SelectVersionFactoryMock extends SelectVersionFactoryImpl {

    public boolean verifyMakeCalled = false;
    public boolean verifyGetAvailableVersionsCalled = false;

    @Override
    public void make(String version) {
        verifyMakeCalled = true;
    }

    @Override
    public String[] getAvailableVersions() {
        verifyGetAvailableVersionsCalled = true;
        return new String[0];
    }
}
