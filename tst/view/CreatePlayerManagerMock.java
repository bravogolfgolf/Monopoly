package game.view;

class CreatePlayerManagerMock implements Manager {

    boolean verifyValidEntryCalled = false;
    boolean verifyInvalidEntryCalled = false;

    @Override
    public void validEntry() {
        verifyValidEntryCalled = true;
    }

    @Override
    public void invalidEntry() {
        verifyInvalidEntryCalled = true;
    }
}
