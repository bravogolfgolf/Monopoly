package game.doubles;

import game.factories.VersionFactory;

public class VersionFactoryMock extends VersionFactory {

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
