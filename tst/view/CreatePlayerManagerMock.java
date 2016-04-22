package game.view;

class CreatePlayerManagerMock implements Manager {

    boolean validUseCaseEntryCalled = false;
    boolean verifyInvalidEntryCalled = false;
    boolean verifyZeroEnteredCalled = false;

    @Override
    public void initialize() {

    }

    @Override
    public void validTextEntry() {
        validUseCaseEntryCalled = true;
    }

    @Override
    public void invalidEntry() {
        verifyInvalidEntryCalled = true;
    }

    @Override
    public void validNumber() {
        verifyZeroEnteredCalled = true;
    }
}
