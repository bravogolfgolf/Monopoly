package game.interactors;

import game.interactors.gamesetup.SelectVersionFactory;
import game.interactors.options.OptionsFactory;

class SelectVersionFactoryMock implements SelectVersionFactory, OptionsFactory {

    boolean verifyCreateMethodCalled = false;
    boolean verifyGetAvailableVersionsCalled = false;

    @Override
    public void make(String version) {
        verifyCreateMethodCalled = true;
    }

    @Override
    public String[] getAvailableVersions() {
        verifyGetAvailableVersionsCalled = true;
        return new String[]{"USA"};
    }
}