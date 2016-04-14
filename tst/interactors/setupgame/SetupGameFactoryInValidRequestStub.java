package game.interactors.setupgame;

class SetupGameFactoryInValidRequestStub extends SetupGameFactoryMock {
    @Override
    public void make(String version) {

        throw new IllegalArgumentException();
    }

    @Override
    public String[] getAvailableVersions() {
        super.getAvailableVersions();
        return new String[]{"USA"};
    }

    @Override
    public boolean isAvailable(String version) {
        super.isAvailable(version);
        return false;
    }
}
