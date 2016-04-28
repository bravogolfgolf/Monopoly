package game.interactors;

import game.interactors.versionoptions.VersionOptionsVersionFactory;

class SelectVersionFactoryMock implements VersionOptionsVersionFactory {

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
