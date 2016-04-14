package game.interactors.setupgame;

class SetupGameFactoryValidRequestStub extends SetupGameFactoryMock {
    @Override
    public void make(String version) {
        super.make(version);
    }

    @Override
    public String[] getAvailableVersions() {
        return super.getAvailableVersions();
    }

    @Override
    public boolean isAvailable(String version) {
        super.isAvailable(version);
        return true;
    }
}
