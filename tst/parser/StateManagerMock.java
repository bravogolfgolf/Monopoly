package game.parser;

class StateManagerMock implements ParserManager {

    boolean validUseCaseEntryCalled = false;
    boolean verifyInvalidEntryCalled = false;
    boolean verifyZeroEnteredCalled = false;

    @Override
    public void validTextEntry(String result) {
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
