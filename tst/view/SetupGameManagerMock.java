package game.view;

class SetupGameManagerMock implements Manager {
    boolean verifyValidEntryCalled = false;
    boolean verifyInvalidEntryCalled = false;

    @Override
    public void promptMessage() {

    }

    @Override
    public void validUseCaseEntry() {
        verifyValidEntryCalled = true;
    }

    @Override
    public void invalidEntry() {
        verifyInvalidEntryCalled = true;

    }
}
