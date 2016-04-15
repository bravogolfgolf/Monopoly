package game.interactors.setupgame;

class SetupGameFactoryValidRequestStub extends SetupGameFactoryMock {

    @Override
    public boolean isAvailable(String version) {
        return true;
    }
}
