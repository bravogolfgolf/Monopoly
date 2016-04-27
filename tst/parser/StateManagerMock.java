package game.parser;

class StateManagerMock implements ParserManager {

    boolean validUseCaseEntryCalled = false;
    boolean verifyInvalidEntryCalled = false;
    boolean verifyZeroEnteredCalled = false;
    boolean verifyOneEnteredCalled = false;
    boolean verifyTwoEnteredCalled = false;

    @Override
    public void validTextEntry(String result) {
        validUseCaseEntryCalled = true;
    }

    @Override
    public void invalidEntry() {
        verifyInvalidEntryCalled = true;
    }

    @Override
    public void zeroEntered() {
        verifyZeroEnteredCalled = true;
    }

    @Override
    public void oneEntered() {
        verifyOneEnteredCalled = true;
    }

    @Override
    public void twoEntered() {
        verifyTwoEnteredCalled = true;
    }
}
