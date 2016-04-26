package game.interactors;

import game.interactors.selectversion.SelectVersionFactory;
import game.interactors.versionoptions.VersionOptionsFactory;

class SelectVersionFactoryMock implements SelectVersionFactory, VersionOptionsFactory {

    boolean verifyMakeCalled = false;
    boolean verifyGetAvailableVersionsCalled = false;

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
