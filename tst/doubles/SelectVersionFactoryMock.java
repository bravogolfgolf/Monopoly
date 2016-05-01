package game.doubles;

import game.interactors.versionoptions.VersionOptionsVersionFactory;

public class SelectVersionFactoryMock implements VersionOptionsVersionFactory {

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
